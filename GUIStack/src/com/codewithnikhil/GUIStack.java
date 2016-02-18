package com.codewithnikhil;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIStack
{
    private JFrame f;//this where all the components will be added
    private NStack global;//this is a global stack which will be used to print the items
    private HashMap<String, NStack> stacks = new HashMap<String, NStack>();//this will hold all the NStack object pointer
    private JButton pushbutton;
    private JButton popbutton;
    private JTextField text;//where user will enter the values
    private JTextArea area;//where the contains of the stack will be displayed
    private JPanel radiopanel;//Constaint of having only 10 Stack As the rows are made 10 here all the radio button will be displayed
    private JPanel panel;//used to group push pop and textfield
    private ButtonGroup radiogroup;//used to group radio button

    public GUIStack(JFrame f)
    {
        this.f = f;
        pushbutton = new JButton("push");
        popbutton = new JButton("pop");
        text = new JTextField(10);
        area = new JTextArea(25, 25);
        radiopanel = new JPanel(new GridLayout(10, 1));
        panel = new JPanel();
        radiogroup = new ButtonGroup();
        area.setEditable(false);
        init();
    }

    private void display()
    {
        area.setText("");
        for (int i = global.getTop(); i >= 0; i--)
        {
            area.append("Data = " + global.getA()[i] + "\n");
        }
    }

    private void init()
    {
        panel.add(pushbutton);
        panel.add(text);
        panel.add(popbutton);
        f.add(panel, BorderLayout.SOUTH);
        f.add(radiopanel, BorderLayout.WEST);
        f.add(area);
        pushbutton.addActionListener((ActionEvent e) ->
        {
            try
            {
                global.push(Integer.parseInt(text.getText()));
                text.setText("");
                display();
            }
            catch (Exception ex)
            {
                Logger.getLogger(GUIStack.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        popbutton.addActionListener((ActionEvent e) ->
        {
            try
            {
                int v = global.pop();
                display();
            }
            catch (Exception ex)
            {
                Logger.getLogger(GUIStack.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public void addToFrame(NStack s)
    {
        String temp = "Stack" + (stacks.size() + 1);
        JRadioButton rb = new JRadioButton(temp);//this will only display the name and not set it internally
        rb.setName(temp);//this will give name to it internally 
        stacks.put(temp, s);
        radiogroup.add(rb);
        radiopanel.add(rb);

        rb.addActionListener((ActionEvent e) ->
        {
            area.setText("");
            JRadioButton temp1 = (JRadioButton) e.getSource();
            String name = temp1.getName();
            global = stacks.get(name);
            display();
        });

        int count = stacks.size();
        if (count == 1)
        {
            rb.setSelected(true);
            area.setText("");
            String name = rb.getName();
            global = stacks.get(name);
            display();
        }
    }
}

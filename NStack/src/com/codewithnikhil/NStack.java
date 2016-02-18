package com.codewithnikhil;

import com.codewithnikhil.IStack;

public class NStack implements IStack
{
    private int[] a = new int[100];
    private int top = -1;
    private String name = new String();
    
    @Override
    public void push(int data)
    {
        a[++top] = data;
    }

    @Override
    public int pop()
    {
        int v = a[top];
        top--;
        return v;
    }

    public int[] getA()
    {
        return a;
    }

    public int getTop()
    {
        return top;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void display()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

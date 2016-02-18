package com.codewithnikhil;

public interface IStack
{
    /**
     *
     * @param v
     * @throws Exception
     */
    public void push(int v) throws Exception;

    public int pop() throws Exception;

    public default int peek() throws Exception
    {
        int v = pop();
        push(v);
        return v;
    }
    void display();
}

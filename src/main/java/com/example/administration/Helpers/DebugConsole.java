package com.example.administration.Helpers;

public class DebugConsole<T>
{
    /**
     * Here i will have debug methods static to call the system dionostics by systemout println
     */

    public void consoleWrite(T model, String msg) {
        System.out.println("Console Write");
        System.out.println(msg + "\n" + model.toString());
    }
}

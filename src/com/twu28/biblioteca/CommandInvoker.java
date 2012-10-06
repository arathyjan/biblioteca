package com.twu28.biblioteca;

public class CommandInvoker {
    Command cmd;
    public CommandInvoker(Command cmd){
        this.cmd=cmd;
    }
    public void setCommand(Command cmd){
        this.cmd=cmd;
    }
    public void invoke(){
        cmd.execute();
    }
}

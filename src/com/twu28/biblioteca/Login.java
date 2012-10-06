package com.twu28.biblioteca;

public class Login implements Command {
    Users[] objUsers;
    Login(Users[] objUsers)
    {
        this.objUsers=objUsers;
    }
    @Override
    public void execute(){
        Users.Login(objUsers);

    }
}

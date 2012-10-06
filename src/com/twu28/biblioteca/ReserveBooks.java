package com.twu28.biblioteca;

public class ReserveBooks implements Command  {
    Books[] objBooks;
    public ReserveBooks(Books[] objBooks)
    {
        this.objBooks=objBooks;

    }
    @Override
    public void execute(){
        if(Users.CheckLoginStatus())
        {
            Books.DisplayBooks(objBooks);
            System.out.println("Enter the code of the book to reserve");
            Books.ReserveBook(Biblioteca.inputOption(),objBooks);
        }
        else
            System.out.println("Sorry you are not logged in");

    }
}

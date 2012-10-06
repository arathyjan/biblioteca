package com.twu28.biblioteca;

public class Books {

    private String Name;
    private int BookStatus;

    public Books(String Name)
    {
        this.Name=Name;
    }

    private void setBookStatus()
    {
        BookStatus=1;
    }
    private int getBookStatus()
    {
        return BookStatus;
    }
    private String DisplayBookDetails()
    {
        return Name;
    }

    public static void DisplayBooks(Books[] objBooks)
    {
        for(int i=0;i<objBooks.length;i++)
        {
            System.out.println((i+1)+"."+objBooks[i].DisplayBookDetails());
        }
    }
    public static boolean ReserveBook(int BookCode,Books[] objBooks)
    {
        if(BookCode>0&&BookCode<=objBooks.length)
        {
            if(objBooks[BookCode-1].getBookStatus()==0)
            {

                objBooks[BookCode-1].setBookStatus();

                System.out.println("\n Thank You! Enjoy the Book \n");
                return true;
            }
            else
            {
                System.out.println("\n Sorry we don't have that book yet. \n");
                return false;
            }
        }
        System.out.println("\n Invalid Book Code \n");
        return false;
    }






}

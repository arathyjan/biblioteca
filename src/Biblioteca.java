import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Biblioteca {

    public static String welcomeNote="WELCOME";
    public static String menuOption[]={"VIEW","RESERVE","CHECK LIBRARY NUMBER","EXIT"};
    Books[] objBooks={new Books("When Tomorrow Comes"),new Books("Inception Point"),new Books("Prisoner Of Birth"),new Books("Hamlet")};

    public static void main(String arg[])
    {
        Biblioteca objBiblioteca=new Biblioteca();
        objBiblioteca.start();
    }

    private void start() {

        System.out.println("*--*--*--*--*");
        System.out.println(welcomeNote);
        System.out.println("*--*--*--*--*");

        int option=0;
        while(option!=4)
        {
            DisplayMenu();
             option= chooseMenuOption(inputOption());
            if(option==1)
            {
                DisplayBooks();
            }
            else if(option==2)
            {
                DisplayBooks();
                System.out.println("Enter the code of the book to reserve");
                 ReserveBook(inputOption());
            }
            else if(option==3)
            {
                System.out.println("Please talk to Librarian.Thank you.");
            }
        }
        System.out.println("----*----*----*----");

    }

    private void DisplayMenu() {
        System.out.println("-------------------");
        System.out.println("MENU");
        System.out.println("-------------------");
        for(int i=0;i<menuOption.length;i++)
            System.out.println((i+1)+"."+menuOption[i]);
        System.out.println("-------------------");

        System.out.println("Enter Your Option : ");
    }

    public int inputOption()    //read from user and output it as such
       {

           BufferedReader readInput=new BufferedReader(new InputStreamReader(System.in));
           int option=0;
           try{
                        option=Integer.parseInt(readInput.readLine());
           }
           catch(Exception ex){}
           return option;
       }
    public int chooseMenuOption(int option) {

        if(option<=0||option>menuOption.length) {
           System.out.println("\n Select A Valid Option!!\n");
            option=0;
        }

        return option;
    }

    public void DisplayBooks()
    {
        for(int i=0;i<objBooks.length;i++)
        {
            System.out.println((i+1)+"."+objBooks[i].returnName());
        }

    }
    public boolean ReserveBook(int BookCode)
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
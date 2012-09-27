import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Biblioteca {

    public static String welcomeNote="WELCOME";
    public static String menuOption[]={"VIEW","RESERVE","CHECK LIBRARY NUMBER","VIEW MOVIES","LOGIN","LOG-OUT","EXIT"};
    Books[] objBooks={new Books("When Tomorrow Comes"),
            new Books("Inception Point"),
            new Books("Prisoner Of Birth"),
            new Books("Hamlet")};
    Movie[] objMovie={new Movie("The Godfather","Francis Ford Coppola",1972,8),
            new Movie("Citizen Kane","Orson Welles",1941,7),
            new Movie("Casablanca","Michael Curtiz",1942,9),
            new Movie("Gone With the Wind","Victor Fleming",1939,6),
            new Movie("Seven Samurai","Akira Kurosawa",1959,5),
            new Movie("Wizard of Oz","Victor Fleming",1939,4),
            new Movie("On the Waterfront","Elia Kazan",1954,8),
            new Movie("The Bridge on the River Kwai","David Lean",1957,5),
            new Movie("Rules Of The Game","Jean Renoir",1939,9),
            new Movie("The Godfather Part II","Francis Ford Coppola",1974,7),
            new Movie("Heroine","Madhur Bhandarkar",2012,5),
            new Movie("Barfi!","Anurag Bhasi",2012,8),
            new Movie("Raaz3","Mohit Suri",2012,5),
            new Movie("Jab Tak Hain Jaan","Yash Copra",2012),
            new Movie("Step Up 4","Scott Speer",2012)};
    Users[] objUsers={new Users("111-1111","arathy","Arathy","arathy@gmail.com",2777833),
            new Users("111-1112","abhay","Abhay","abhay@yahoo.com",2749710),
            new Users("111-1113","arun","Arun","arun@gmail.com",2345678)};

    public static String userLogin=null;


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
        while(option!=menuOption.length)
        {
            DisplayMenu();
            option= chooseMenuOption(inputOption());
            if(option==1)
            {
                DisplayBooks();
            }
            else if(option==2)
            {
                if(CheckLoginStatus())
                {
                    DisplayBooks();
                    System.out.println("Enter the code of the book to reserve");
                    ReserveBook(inputOption());
                }
                else
                    System.out.println("Sorry you are not logged in");
            }
            else if(option==3)
            {
                if(CheckLoginStatus())
                {
                    DisplayUserDetails();
                }
                else
                System.out.println("Please talk to Librarian.Thank you.");
            }
            else if(option==4)
            {

                DisplayMovie();
            }
            else if(option==5)
            {
                Login();
            }
            else if(option==6)
            {
                if(CheckLoginStatus())
                LogOut();
            }
        }
        System.out.println("----*----*----*----");

    }

    private void DisplayUserDetails() {
        for(int  i=0;i<objUsers.length;i++)
        {
            if(objUsers[i].returnUserName().equals(userLogin))
            {
                objUsers[i].DisplayUserDetails();
                break;
            }
        }
    }

    public boolean CheckLoginStatus()
    {
        if(userLogin!=null)
            return true;
        return false;

    }

    private void LogOut() {
        System.out.println("You have successfully logged out");
        userLogin=null;
    }

    private void Login() {
        BufferedReader readInput=new BufferedReader(new InputStreamReader(System.in));
        String UserName="";
        String Password="";
        System.out.println("UserName:");
        try{
            UserName=readInput.readLine();
        }
        catch(Exception ex){}
        System.out.println("Password:");
        try{
            Password=readInput.readLine();
        }
        catch(Exception ex){}

        userLogin=ValidUser(UserName,Password);

    }
    String ValidUser(String UserName,String Password)
    {
        for(int i=0;i<objUsers.length;i++)
        {
            if(objUsers[i].Authentication(UserName,Password))
            {
             System.out.println("You are successfully logged in");
                return UserName;
            }
        }
        System.out.println("Wrong Username or Password");
        return null;
    }

    private void DisplayMovie() {
        System.out.println("\n");
        System.out.printf("%-30s %-8s %-30s %s", "MOVIE", "YEAR", "DIRECTOR", "RATING");
        System.out.println();
        for(int i=0;i<objMovie.length;i++)
        objMovie[i].DisplayMovieDetails();
        System.out.println("\n\n");
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
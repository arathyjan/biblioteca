import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

        ArrayList<Command> menuArrayList=new ArrayList<Command>();
        menuArrayList.add(new DisplayBooks(objBooks));
        menuArrayList.add(new ReserveBooks(objBooks));
        menuArrayList.add(new DisplayUserDetails(objUsers));
        menuArrayList.add(new DisplayMovie(objMovie));
        menuArrayList.add(new Login(objUsers));
        menuArrayList.add(new Logout());
        Command command=null;
        CommandInvoker commandInvoker;


        System.out.println("*--*--*--*--*");
        System.out.println(welcomeNote);
        System.out.println("*--*--*--*--*");

        int option=0;
        while(option!=menuOption.length)
        {
            DisplayMenu();
            option= chooseMenuOption(inputOption());
            if(option>0&&option<=menuArrayList.size())
            command=menuArrayList.get(option-1);
            commandInvoker=new CommandInvoker(command);
            commandInvoker.invoke();


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

    public static int inputOption()    //read from user and output it as such
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


}
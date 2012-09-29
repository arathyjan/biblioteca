import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Users {
    private String UserName;
    private String Password;
    private String Name;
    private String EMail;
    private int PhoneNumber;

    public Users(String UserName,String Password,String Name,String Email,int PhoneNumber)
    {
        this.UserName=UserName;
        this.Password=Password;
        this.Name=Name;
        this.EMail=Email;
        this.PhoneNumber=PhoneNumber;
    }

    public static void DisplayUserDetails(Users[] objUsers) {
        for(int  i=0;i<objUsers.length;i++)
        {
            if(objUsers[i].returnUserName().equals(Biblioteca.userLogin))
            {
                objUsers[i].DisplayUser();
                break;
            }
        }
    }
    public static boolean CheckLoginStatus()
    {
        if(Biblioteca.userLogin!=null)
            return true;
        return false;

    }
    public static void LogOut() {
        System.out.println("You have successfully logged out");
        Biblioteca.userLogin=null;
    }

    public static void Login(Users[] objUsers) {
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

        Biblioteca.userLogin=ValidUser(objUsers,UserName,Password);

    }
    public static String ValidUser(Users[] objUsers,String UserName,String Password)
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



    public boolean Authentication(String UserName,String Password)
    {
        if(UserName.equals(this.UserName)&&Password.equals(this.Password))
            return true;
        return false;

    }

    private String returnUserName()
    {
        return UserName;
    }

    private void DisplayUser()
    {
        System.out.println("NAME:"+Name);
        System.out.println("EMAIL:"+EMail);
        System.out.println("PHONE NUMBER:"+PhoneNumber);
    }

}

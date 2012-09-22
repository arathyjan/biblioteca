public class Users {
    String UserName;
    String Password;
    String Name;
    String EMail;
    int PhoneNumber;

    public Users(String UserName,String Password,String Name,String Email,int PhoneNumber)
    {
        this.UserName=UserName;
        this.Password=Password;
        this.Name=Name;
        this.EMail=Email;
        this.PhoneNumber=PhoneNumber;
    }

    public boolean Authentication(String UserName,String Password)
    {
        if(UserName.equals(this.UserName)&&Password.equals(this.Password))
            return true;
        return false;

    }

    public String returnUserName()
    {
        return UserName;
    }

    void DisplayUserDetails()
    {
        System.out.println("NAME:"+Name);
        System.out.println("EMAIL:"+EMail);
        System.out.println("PHONE NUMBER:"+PhoneNumber);
    }

}

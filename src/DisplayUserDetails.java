
public class DisplayUserDetails implements Command {
    Users[] objUsers;
    public DisplayUserDetails(Users[] objUsers){
        this.objUsers=objUsers;
    }
    @Override
    public void execute(){
        if(Users.CheckLoginStatus())
        {
            Users.DisplayUserDetails(objUsers);
        }
        else
            System.out.println("Please talk to Librarian.Thank you.");

    }
}

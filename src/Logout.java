
public class Logout implements Command {

    @Override
    public void execute(){
        if(Users.CheckLoginStatus())
            Users.LogOut();
    }


}


public class DisplayBooks implements Command {
    Books[] objBooks;
    public DisplayBooks(Books[] objBooks){
        this.objBooks=objBooks;

    }
    @Override
    public void execute(){
        Books.DisplayBooks(objBooks);

    }
}

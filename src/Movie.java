
public class Movie {
    String Name;
    String Director;
    Integer Rating=null;
    int Year;

    public Movie(String Name,String Director,int Year,int Rating)
    {
        this.Name=Name;
        this.Director=Director;
        this.Year=Year;
        this.Rating=Rating;

    }

    public Movie(String Name,String Director,int Year)
    {
        this.Name=Name;
        this.Director=Director;
        this.Year=Year;

    }

    public void DisplayMovieDetails()
    {
       // System.out.print(Name+"\t"+Year+"\t"+Director+"\t");
        System.out.printf("%-30s %-8d %-30s",Name,Year,Director);
        if(Rating==null)
            System.out.print("N/A");
        else
        {
        for(int i=0;i<Rating;i++)
        {
        System.out.print("*");
        }
        }
        System.out.print("\n");
    }


}

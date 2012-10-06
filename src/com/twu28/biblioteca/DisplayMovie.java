package com.twu28.biblioteca;

public class DisplayMovie implements Command {
    Movie[] objMovie;
    public DisplayMovie(Movie[] objMovie)
    {
        this.objMovie=objMovie;
    }
    @Override
    public void execute(){
        Movie.DisplayMovie(objMovie);

    }
}

package com.twu.biblioteca;

public class Movie {

    private String movieTitle;
    private String director;
    private String releaseYear;
    private String rating;

    public Movie(){

    }

    public Movie(String movieTitle, String director, String releaseYear, String rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this. releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieTitle='" + movieTitle + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }
}

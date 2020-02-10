package com.twu.biblioteca;

public class Movie implements Title{

    private String title;
    private String director;
    private String releaseYear;
    private String rating;

    public Movie(){

    }

    public Movie(String title, String director, String releaseYear, String rating){
        this.title = title;
        this.director = director;
        this. releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String movieTitle) {
        this.title = title;
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
                "movieTitle='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }
}

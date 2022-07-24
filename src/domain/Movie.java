package domain;

import enums.FilmsGroup;

public class Movie {
    private String title;
    private FilmsGroup filmsGroup;

    public Movie(String title, FilmsGroup filmsGroup) {

        this.title = title;
        this.filmsGroup= filmsGroup;
    }

    public String getTitle() {
        return title;
    }

    public FilmsGroup getFilmsGroup() {
        return filmsGroup;
    }
}

package domain;

import enums.FilmsGroup;

public class Movie {
    private final String title;
    private final FilmsGroup filmsGroup;

    public Movie(String title, FilmsGroup filmsGroup) {
        this.title = title;
        this.filmsGroup = filmsGroup;
    }

    public String getTitle() {
        return title;
    }

    public FilmsGroup getFilmsGroup() {
        return filmsGroup;
    }
}

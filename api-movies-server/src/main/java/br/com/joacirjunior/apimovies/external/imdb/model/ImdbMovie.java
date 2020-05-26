package br.com.joacirjunior.apimovies.external.imdb.model;

import java.util.Objects;

public class ImdbMovie {

    private String title;

    private String identifier;

    private String link;

    public ImdbMovie(){
    }

    public ImdbMovie(String title, String identifier, String link) {
        this.title = title;
        this.identifier = identifier;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImdbMovie imdbMovie = (ImdbMovie) o;
        return Objects.equals(title, imdbMovie.title) &&
                Objects.equals(identifier, imdbMovie.identifier) &&
                Objects.equals(link, imdbMovie.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, identifier, link);
    }

    @Override
    public String toString() {
        return "ImdbMovie{" +
                "title='" + title + '\'' +
                ", identifier='" + identifier + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}

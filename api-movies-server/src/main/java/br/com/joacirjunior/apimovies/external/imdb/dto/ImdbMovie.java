package br.com.joacirjunior.apimovies.external.imdb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ImdbMovie {

    @SerializedName("l")
    private String title;

    @SerializedName("id")
    private String identifier;

    @SerializedName("s")
    private String stars;

    @SerializedName("y")
    private Integer year;

    @SerializedName("i")
    private List<Object> image;

    @SerializedName("v")
    private List<ImdbVideoMovie> video;

    public ImdbMovie(){
    }

    public ImdbMovie(String title, String identifier, String stars, Integer year, List<Object> image) {
        this.title = title;
        this.identifier = identifier;
        this.stars = stars;
        this.year = year;
        this.image = image;
    }

    public ImdbMovie(String title, String identifier, String stars, Integer year,
                     List<Object> image, List<ImdbVideoMovie> video) {
        this.title = title;
        this.identifier = identifier;
        this.stars = stars;
        this.year = year;
        this.image = image;
        this.video = video;
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

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Object> getImage() {
        return image;
    }

    public void setImage(List<Object> image) {
        this.image = image;
    }

    public List<ImdbVideoMovie> getVideo() {
        return video;
    }

    public void setVideo(List<ImdbVideoMovie> video) {
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImdbMovie imdbMovie = (ImdbMovie) o;
        return Objects.equals(title, imdbMovie.title) &&
                Objects.equals(identifier, imdbMovie.identifier) &&
                Objects.equals(stars, imdbMovie.stars) &&
                Objects.equals(year, imdbMovie.year) &&
                Objects.equals(image, imdbMovie.image) &&
                Objects.equals(video, imdbMovie.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, identifier, stars, year, image, video);
    }

    @Override
    public String toString() {
        return "ImdbMovie{" +
                "title='" + title + '\'' +
                ", identifier='" + identifier + '\'' +
                ", stars='" + stars + '\'' +
                ", year=" + year +
                ", image=" + image +
                ", video=" + video +
                '}';
    }

}

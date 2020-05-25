package br.com.joacirjunior.apimovies.external.imdb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ImdbVideoMovie {

    @SerializedName("l")
    private String description;

    @SerializedName("id")
    private String identifier;

    @SerializedName("s")
    private String time;

    @SerializedName("i")
    private List<Object> image;

    public ImdbVideoMovie(){
    }

    public ImdbVideoMovie(String description, String identifier, String time, List<Object> image) {
        this.description = description;
        this.identifier = identifier;
        this.time = time;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Object> getImage() {
        return image;
    }

    public void setImage(List<Object> image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImdbVideoMovie that = (ImdbVideoMovie) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(identifier, that.identifier) &&
                Objects.equals(time, that.time) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, identifier, time, image);
    }

    @Override
    public String toString() {
        return "ImdbVideoMovie{" +
                "description='" + description + '\'' +
                ", identifier='" + identifier + '\'' +
                ", time='" + time + '\'' +
                ", image=" + image +
                '}';
    }

}

package br.com.joacirjunior.apimovies.external.imdb.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ImdbResponse {

    @SerializedName("v")
    private Integer version;

    @SerializedName("q")
    private String query;

    @SerializedName("d")
    private List<ImdbMovie> moviesData;

    public ImdbResponse(){
    }

    public ImdbResponse(Integer version, String query, List<ImdbMovie> moviesData) {
        this.version = version;
        this.query = query;
        this.moviesData = moviesData;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<ImdbMovie> getMoviesData() {
        return moviesData;
    }

    public void setMoviesData(List<ImdbMovie> moviesData) {
        this.moviesData = moviesData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImdbResponse that = (ImdbResponse) o;
        return Objects.equals(version, that.version) &&
                Objects.equals(query, that.query) &&
                Objects.equals(moviesData, that.moviesData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, query, moviesData);
    }

    @Override
    public String toString() {
        return "ImdbResponse{" +
                "version=" + version +
                ", query='" + query + '\'' +
                ", moviesData=" + moviesData +
                '}';
    }

}

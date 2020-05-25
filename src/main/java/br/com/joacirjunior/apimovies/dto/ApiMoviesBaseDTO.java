package br.com.joacirjunior.apimovies.dto;

import java.util.Objects;

public class ApiMoviesBaseDTO {

    private Integer length;
    private String content;

    public ApiMoviesBaseDTO(){
    }

    public ApiMoviesBaseDTO(Integer length, String content) {
        this.length = length;
        this.content = content;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiMoviesBaseDTO baseModel = (ApiMoviesBaseDTO) o;
        return Objects.equals(length, baseModel.length) &&
                Objects.equals(content, baseModel.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, content);
    }

    @Override
    public String toString() {
        return "ApiMoviesBaseModel{" +
                "length=" + length +
                ", content='" + content + '\'' +
                '}';
    }

}

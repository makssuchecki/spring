
package com.example.artworks.model;

public class Artwork{
    private String id;
    private String name;
    private String type;
    private Integer year;
    private String artist;
    private String style;
    private String technique;

    public String getId() {
        return id;
    }

    public Artwork() {
    }

    public Artwork(String id, String name, String type, Integer year, String artist, String style, String technique) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.year = year;
        this.artist = artist;
        this.style = style;
        this.technique = technique;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
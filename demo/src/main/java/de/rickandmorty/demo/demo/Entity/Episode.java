package de.rickandmorty.demo.demo.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Episode extends AbstractEntity {

    private String name;
    private String type;
    private String air_date;
    private String episode;

    @ManyToMany(mappedBy = "Episode", fetch = FetchType.LAZY)
    private Character[] residents;

    public Character[] getResidents() {
        return this.residents;
    }

    public void setResidents(Character[] residents) {
        this.residents = residents;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAir_date() {
        return this.air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode() {
        return this.episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
    @JsonCreator
    public Episode() {
        super("Episode");
    }

    @JsonCreator
    public Episode(int id, String name, String air_date, String episode) {
        super("Episode");
        this.id = id;
        this.name = name;
        this.air_date = air_date;
        this.episode = episode;

    }

    public String toString() {
        return this.getUrl();
    }

}

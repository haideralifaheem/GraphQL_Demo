package de.rickandmorty.demo.demo.Entity;

import java.util.ArrayList;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Character extends AbstractEntity {

    public enum Status {
        Alive,
        Dead,
        Unknown

    }

    public enum Gender {
        Male,
        Female,
        Genderless,
        Unknown

    }

    private String name;
    private Status status;
    private String species;
    private String type;
    private Gender gender;
    private Location origin;
    private Location location;
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "character_episodes", joinColumns = {
            @JoinColumn(name = "character_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false, updatable = false) })
    private ArrayList<Episode> episode;

    @JsonCreator
    public Character(int id) {
        super("Character");
        this.setId(id);
    }

    @JsonCreator
    public Character(int id, String name, Status status, String species, String type, Gender gender, Location origin,
            Location location, String image, ArrayList<Episode> episodes) {
        super("Character");
        this.setId(id);
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episode = episodes;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getOrigin() {
        return this.origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Episode> getEpisode() {
        return this.episode;
    }

    public void setEpisode(ArrayList<Episode> episode) {
        this.episode = episode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Character character = (Character) o;

        return this.id == character.id;
    }

    @Override
    public String toString() {
        return this.getUrl();
    }
}
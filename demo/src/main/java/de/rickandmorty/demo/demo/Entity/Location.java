package de.rickandmorty.demo.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.data.mongodb.core.mapping.DBRef;

@Entity
public class Location extends AbstractEntity {
   
    private String name;
    private String type;
    private String dimension;
    @DBRef
    @ManyToMany(mappedBy = "Location", fetch = FetchType.LAZY)
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

    public String getDimension() {
        return this.dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    @JsonCreator
    public Location() {
        super("Location");
    }
    @JsonCreator
    public Location(int id,String name,
            String type,
            String dimension) {
        super("Location");
        this.id=id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;

    }
}

package de.rickandmorty.demo.demo.Entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    private String created = new SimpleDateFormat("yyyyMMdd HHmmss").format(Calendar.getInstance().getTime());

   
    private String baseUrl="https://rickandmortyapi.com/Api";
    @Transient
    private String endPoint;

    public AbstractEntity(String endpoint) {
        this.endPoint = endpoint;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        if (endPoint.length() > 0) {
            return baseUrl+ "/" + endPoint + "/" + id;
        }
        return baseUrl + '/' + id;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}

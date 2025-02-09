/**
 * @Author Albert Piekielny 2020
 */
package com.example.apblue.jpahibernateexamples.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "actor_info")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ActorInfo.findAll", query = "SELECT a FROM ActorInfo a"),
        @NamedQuery(name = "ActorInfo.findByActorId", query = "SELECT a FROM ActorInfo a WHERE a.actorId = :actorId"),
        @NamedQuery(name = "ActorInfo.findByFirstName", query = "SELECT a FROM ActorInfo a WHERE a.firstName = :firstName"),
        @NamedQuery(name = "ActorInfo.findByLastName", query = "SELECT a FROM ActorInfo a WHERE a.lastName = :lastName")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="actorId")
public class ActorInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "actor_id")
    private short actorId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;

    @Lob
    @Size(max = 65535)
    @Column(name = "film_info")
    private String filmInfo;

    public ActorInfo() {
    }

    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

}

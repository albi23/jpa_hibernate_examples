/**
 * @Author Albert Piekielny 2020
 */

package com.example.apblue.jpahibernateexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
        @NamedQuery(name = "Actor.findByActorId", query = "SELECT a FROM Actor a WHERE a.actorId = :actorId"),
        @NamedQuery(name = "Actor.findByFirstName", query = "SELECT a FROM Actor a WHERE a.firstName = :firstName"),
        @NamedQuery(name = "Actor.findByLastName", query = "SELECT a FROM Actor a WHERE a.lastName = :lastName"),
        @NamedQuery(name = "Actor.findByLastUpdate", query = "SELECT a FROM Actor a WHERE a.lastUpdate = :lastUpdate")})

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "actorId")
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "actor_id")
    private Short actorId;

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

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "actor", fetch = FetchType.LAZY)
    private List<FilmActor> filmActorCollection = new ArrayList<>();

    public Actor() {
    }

    public Actor(Short actorId) {
        this.actorId = actorId;
    }

    public Actor(Short actorId, String firstName, String lastName, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public List<FilmActor> getFilmActorCollection() {
        return filmActorCollection;
    }

    public void setFilmActorCollection(List<FilmActor> filmActorCollection) {
        this.filmActorCollection = filmActorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actorId != null ? actorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.actorId == null && other.actorId != null) || (this.actorId != null && !this.actorId.equals(other.actorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actor[ actorId=" + actorId + " ]";
    }

}

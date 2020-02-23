/**
 * @Author Albert Piekielny 2020
 */

package com.example.apblue.jpahibernateexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "language")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
        @NamedQuery(name = "Language.findByLanguageId", query = "SELECT l FROM Language l WHERE l.languageId = :languageId"),
        @NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name = :name"),
        @NamedQuery(name = "Language.findByLastUpdate", query = "SELECT l FROM Language l WHERE l.lastUpdate = :lastUpdate")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="languageId")
public class Language  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "language_id")
    private Short languageId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date lastUpdate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "originalLanguageId")
    private Collection<Film> filmCollection;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "languageId")
    private Collection<Film> filmCollection1;


    public Language() {
    }

    public Language(Short languageId) {
        this.languageId = languageId;
    }

    public Language(Short languageId, String name, Date lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<Film> getFilmCollection() {
        return filmCollection;
    }

    public void setFilmCollection(Collection<Film> filmCollection) {
        this.filmCollection = filmCollection;
    }

    @XmlTransient
    public Collection<Film> getFilmCollection1() {
        return filmCollection1;
    }

    public void setFilmCollection1(Collection<Film> filmCollection1) {
        this.filmCollection1 = filmCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Language[ languageId=" + languageId + " ]";
    }

}

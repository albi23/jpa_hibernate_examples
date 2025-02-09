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
@Table(name = "film_text")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "FilmText.findAll", query = "SELECT f FROM FilmText f"),
        @NamedQuery(name = "FilmText.findByFilmId", query = "SELECT f FROM FilmText f WHERE f.filmId = :filmId"),
        @NamedQuery(name = "FilmText.findByTitle", query = "SELECT f FROM FilmText f WHERE f.title = :title")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="filmId")
public class FilmText  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "film_id")
    private Short filmId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;

    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;


    public FilmText() {
    }

    public FilmText(Short filmId) {
        this.filmId = filmId;
    }

    public FilmText(Short filmId, String title) {
        this.filmId = filmId;
        this.title = title;
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmId != null ? filmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmText)) {
            return false;
        }
        FilmText other = (FilmText) object;
        if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FilmText[ filmId=" + filmId + " ]";
    }

}

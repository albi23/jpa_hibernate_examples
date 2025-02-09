/**
 * @Author Albert Piekielny 2020
 */

package com.example.apblue.jpahibernateexamples.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Embeddable
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="filmId")
public class FilmCategoryPK  implements Serializable {

//    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "film_id")
    private short filmId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private short categoryId;


    public FilmCategoryPK() {
    }

    public FilmCategoryPK(short filmId, short categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) filmId;
        hash += (int) categoryId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmCategoryPK)) {
            return false;
        }
        FilmCategoryPK other = (FilmCategoryPK) object;
        if (this.filmId != other.filmId) {
            return false;
        }
        if (this.categoryId != other.categoryId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FilmCategoryPK[ filmId=" + filmId + ", categoryId=" + categoryId + " ]";
    }

}

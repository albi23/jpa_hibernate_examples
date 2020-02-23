/*
 *  Zemian Deng 2014
 */

package com.example.apblue.jpahibernateexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
        @NamedQuery(name = "Inventory.findByInventoryId", query = "SELECT i FROM Inventory i WHERE i.inventoryId = :inventoryId"),
        @NamedQuery(name = "Inventory.findByLastUpdate", query = "SELECT i FROM Inventory i WHERE i.lastUpdate = :lastUpdate")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="inventoryId")
@JsonIgnoreProperties(value = {"filmId"})
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date lastUpdate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "inventoryId")
    private Collection<Rental> rentalCollection;

    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Store storeId;

    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Film filmId;


    public Inventory() {
    }

    public Inventory(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Inventory(Integer inventoryId, Date lastUpdate) {
        this.inventoryId = inventoryId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<Rental> getRentalCollection() {
        return rentalCollection;
    }

    public void setRentalCollection(Collection<Rental> rentalCollection) {
        this.rentalCollection = rentalCollection;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryId != null ? inventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryId == null && other.inventoryId != null) || (this.inventoryId != null && !this.inventoryId.equals(other.inventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventory[ inventoryId=" + inventoryId + " ]";
    }

}

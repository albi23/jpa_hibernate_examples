/*
 *  Zemian Deng 2014
 */

package com.example.apblue.jpahibernateexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "store")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s"),
        @NamedQuery(name = "Store.findByStoreId", query = "SELECT s FROM Store s WHERE s.storeId = :storeId"),
        @NamedQuery(name = "Store.findByLastUpdate", query = "SELECT s FROM Store s WHERE s.lastUpdate = :lastUpdate")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="storeId")
public class Store  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_id")
    private Short storeId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date lastUpdate;

    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    @OneToOne(optional = false)
    private Staff managerStaffId;

    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Address addressId;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "storeId")
    private Collection<Customer> customerCollection;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "storeId")
    private Collection<Staff> staffCollection;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "storeId")
    private Collection<Inventory> inventoryCollection;


    public Store() {
    }

    public Store(Short storeId) {
        this.storeId = storeId;
    }

    public Store(Short storeId, Date lastUpdate) {
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    public Short getStoreId() {
        return storeId;
    }

    public void setStoreId(Short storeId) {
        this.storeId = storeId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Staff getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Staff managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Store[ storeId=" + storeId + " ]";
    }

}

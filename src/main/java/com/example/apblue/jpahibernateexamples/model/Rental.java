/**
 * @Author Albert Piekielny 2020
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
@Table(name = "rental")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Rental.findAll", query = "SELECT r FROM Rental r"),
        @NamedQuery(name = "Rental.findByRentalId", query = "SELECT r FROM Rental r WHERE r.rentalId = :rentalId"),
        @NamedQuery(name = "Rental.findByRentalDate", query = "SELECT r FROM Rental r WHERE r.rentalDate = :rentalDate"),
        @NamedQuery(name = "Rental.findByReturnDate", query = "SELECT r FROM Rental r WHERE r.returnDate = :returnDate"),
        @NamedQuery(name = "Rental.findByLastUpdate", query = "SELECT r FROM Rental r WHERE r.lastUpdate = :lastUpdate")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="rentalId")
@JsonIgnoreProperties(value = {"customerId", "inventoryId"})

public class Rental  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rental_id")
    private Integer rentalId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rental_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date rentalDate;

    @Column(name = "return_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date lastUpdate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "rentalId")
    private Collection<Payment> paymentCollection;

    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Staff staffId;

    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Inventory inventoryId;

    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Customer customerId;


    public Rental() {
    }

    public Rental(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Rental(Integer rentalId, Date rentalDate, Date lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalId != null ? rentalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.rentalId == null && other.rentalId != null) || (this.rentalId != null && !this.rentalId.equals(other.rentalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rental[ rentalId=" + rentalId + " ]";
    }

}

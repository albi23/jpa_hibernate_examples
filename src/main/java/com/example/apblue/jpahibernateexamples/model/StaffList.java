/*
 *  Zemian Deng 2014
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
@Table(name = "staff_list")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "StaffList.findAll", query = "SELECT s FROM StaffList s"),
        @NamedQuery(name = "StaffList.findById", query = "SELECT s FROM StaffList s WHERE s.id = :id"),
        @NamedQuery(name = "StaffList.findByName", query = "SELECT s FROM StaffList s WHERE s.name = :name"),
        @NamedQuery(name = "StaffList.findByAddress", query = "SELECT s FROM StaffList s WHERE s.address = :address"),
        @NamedQuery(name = "StaffList.findByZipCode", query = "SELECT s FROM StaffList s WHERE s.zipCode = :zipCode"),
        @NamedQuery(name = "StaffList.findByPhone", query = "SELECT s FROM StaffList s WHERE s.phone = :phone"),
        @NamedQuery(name = "StaffList.findByCity", query = "SELECT s FROM StaffList s WHERE s.city = :city"),
        @NamedQuery(name = "StaffList.findByCountry", query = "SELECT s FROM StaffList s WHERE s.country = :country"),
        @NamedQuery(name = "StaffList.findBySid", query = "SELECT s FROM StaffList s WHERE s.sid = :sid")})

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class StaffList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private @NotNull Integer id;

    @Size(max = 91)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;

    @Size(max = 10)
    @Column(name = "zip code")
    private String zipCode;

    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "country")
    private String country;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SID")
    private short sid;


    public StaffList() {
    }

    public @NotNull Integer getId() {
        return id;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public short getSid() {
        return sid;
    }

    public void setSid(short sid) {
        this.sid = sid;
    }

}

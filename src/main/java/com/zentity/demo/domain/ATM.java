package com.zentity.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "atm", indexes = @Index(columnList = "loc_lat_centroid, loc_long_centroid"))
public class ATM {

    @Transient
    private int distanceMeters;

    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "location", length = 128)
    private String location;

    @Column(name = "provider", length = 128)
    private String provider;

    @Column(name = "address", length = 128)
    private String address;

    @Column(name = "city", length = 64)
    private String city;

    @Column(name = "state", length = 64)
    private String state;

    @Column(name = "postal", length = 16)
    private String postal;

    @Column(name = "country", length = 64)
    private String country;

    @Column(name = "loc_lat_centroid", precision = 10, scale = 7)
    private Double locLatCentroid;

    @Column(name = "loc_long_centroid", precision = 10, scale = 7)
    private Double locLongCentroid;

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(int distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLocLatCentroid() {
        return locLatCentroid;
    }

    public void setLocLatCentroid(Double locLatCentroid) {
        this.locLatCentroid = locLatCentroid;
    }

    public Double getLocLongCentroid() {
        return locLongCentroid;
    }

    public void setLocLongCentroid(Double locLongCentroid) {
        this.locLongCentroid = locLongCentroid;
    }
}

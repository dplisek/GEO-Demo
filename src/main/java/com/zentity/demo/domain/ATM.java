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

    @Column(name = "location")
    private String location;

    @Column(name = "location_notes")
    private String locationNotes;

    @Column(name = "provider")
    private String provider;

    @Column(name = "provider_notes")
    private String providerNotes;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal")
    private String postal;

    @Column(name = "zip_full")
    private String zipFull;

    @Column(name = "country")
    private String country;

    @Column(name = "flag_visa")
    private String flagVisa;

    @Column(name = "flag_mc")
    private String flagMc;

    @Column(name = "flag_247")
    private String flag247;

    @Column(name = "flag_deposit")
    private String flagDeposit;

    @Column(name = "flag_driveup")
    private String flagDriveup;

    @Column(name = "loc_country")
    private String locCountry;

    @Column(name = "loc_area_code")
    private String locAreaCode;

    @Column(name = "loc_FIPS")
    private String locFIPS;

    @Column(name = "loc_MSA")
    private String locMSA;

    @Column(name = "loc_PMSA")
    private String locPMSA;

    @Column(name = "loc_TZ")
    private String locTZ;

    @Column(name = "loc_DST")
    private String locDST;

    @Column(name = "loc_lat_centroid", columnDefinition = "decimal(10,7)")
    private Double locLatCentroid;

    @Column(name = "loc_lat_poly", columnDefinition = "decimal(10,7)")
    private Double locLatPoly;

    @Column(name = "loc_long_centroid", columnDefinition = "decimal(10,7)")
    private Double locLongCentroid;

    @Column(name = "loc_long_poly", columnDefinition = "decimal(10,7)")
    private Double locLongPoly;

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

    public String getLocationNotes() {
        return locationNotes;
    }

    public void setLocationNotes(String locationNotes) {
        this.locationNotes = locationNotes;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderNotes() {
        return providerNotes;
    }

    public void setProviderNotes(String providerNotes) {
        this.providerNotes = providerNotes;
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

    public String getZipFull() {
        return zipFull;
    }

    public void setZipFull(String zipFull) {
        this.zipFull = zipFull;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlagVisa() {
        return flagVisa;
    }

    public void setFlagVisa(String flagVisa) {
        this.flagVisa = flagVisa;
    }

    public String getFlagMc() {
        return flagMc;
    }

    public void setFlagMc(String flagMc) {
        this.flagMc = flagMc;
    }

    public String getFlag247() {
        return flag247;
    }

    public void setFlag247(String flag247) {
        this.flag247 = flag247;
    }

    public String getFlagDeposit() {
        return flagDeposit;
    }

    public void setFlagDeposit(String flagDeposit) {
        this.flagDeposit = flagDeposit;
    }

    public String getFlagDriveup() {
        return flagDriveup;
    }

    public void setFlagDriveup(String flagDriveup) {
        this.flagDriveup = flagDriveup;
    }

    public String getLocCountry() {
        return locCountry;
    }

    public void setLocCountry(String locCountry) {
        this.locCountry = locCountry;
    }

    public String getLocAreaCode() {
        return locAreaCode;
    }

    public void setLocAreaCode(String locAreaCode) {
        this.locAreaCode = locAreaCode;
    }

    public String getLocFIPS() {
        return locFIPS;
    }

    public void setLocFIPS(String locFIPS) {
        this.locFIPS = locFIPS;
    }

    public String getLocMSA() {
        return locMSA;
    }

    public void setLocMSA(String locMSA) {
        this.locMSA = locMSA;
    }

    public String getLocPMSA() {
        return locPMSA;
    }

    public void setLocPMSA(String locPMSA) {
        this.locPMSA = locPMSA;
    }

    public String getLocTZ() {
        return locTZ;
    }

    public void setLocTZ(String locTZ) {
        this.locTZ = locTZ;
    }

    public String getLocDST() {
        return locDST;
    }

    public void setLocDST(String locDST) {
        this.locDST = locDST;
    }

    public Double getLocLatCentroid() {
        return locLatCentroid;
    }

    public void setLocLatCentroid(Double locLatCentroid) {
        this.locLatCentroid = locLatCentroid;
    }

    public Double getLocLatPoly() {
        return locLatPoly;
    }

    public void setLocLatPoly(Double locLatPoly) {
        this.locLatPoly = locLatPoly;
    }

    public Double getLocLongCentroid() {
        return locLongCentroid;
    }

    public void setLocLongCentroid(Double locLongCentroid) {
        this.locLongCentroid = locLongCentroid;
    }

    public Double getLocLongPoly() {
        return locLongPoly;
    }

    public void setLocLongPoly(Double locLongPoly) {
        this.locLongPoly = locLongPoly;
    }

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(int distanceMeters) {
        this.distanceMeters = distanceMeters;
    }
}

package com.example.lab3.entities;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "discount_code")
    private String discountCode;
    @Basic
    @Column(name = "zip")
    private String zip;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "addressline1")
    private String addressline1;
    @Basic
    @Column(name = "addressline2")
    private String addressline2;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "credit_limit")
    private BigInteger creditLimit;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
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

    public BigInteger getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigInteger creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (discountCode != null ? !discountCode.equals(customer.discountCode) : customer.discountCode != null)
            return false;
        if (zip != null ? !zip.equals(customer.zip) : customer.zip != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (addressline1 != null ? !addressline1.equals(customer.addressline1) : customer.addressline1 != null)
            return false;
        if (addressline2 != null ? !addressline2.equals(customer.addressline2) : customer.addressline2 != null)
            return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (state != null ? !state.equals(customer.state) : customer.state != null) return false;
        if (creditLimit != null ? !creditLimit.equals(customer.creditLimit) : customer.creditLimit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (discountCode != null ? discountCode.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (addressline1 != null ? addressline1.hashCode() : 0);
        result = 31 * result + (addressline2 != null ? addressline2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        return result;
    }
}

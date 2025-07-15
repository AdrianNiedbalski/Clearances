package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customs_office")
public class CustomsOffice {

    @Id
    @Column(name = "customs_office_id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "office_code", nullable = false, unique = true, length = 255)
    private String officeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public CustomsOffice() {}

    public CustomsOffice(Integer id,
                         String name,
                         String officeCode,
                         Address address,
                         Contact contact) {
        this.id = id;
        this.name = name;
        this.officeCode = officeCode;
        this.address = address;
        this.contact = contact;
    }

    // --- Gettery i settery ---

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeCode() {
        return officeCode;
    }
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "CustomsOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }
}

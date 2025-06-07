package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customs_offices")
public class CustomsOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customs_office_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "office_code", nullable = false, unique = true)
    private String officeCode;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public CustomsOffice() {}

    public CustomsOffice(String name, String officeCode, Address address, Contact contact) {
        this.name = name;
        this.officeCode = officeCode;
        this.address = address;
        this.contact = contact;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getOfficeCode() { return officeCode; }
    public Address getAddress() { return address; }
    public Contact getContact() { return contact; }

    public void setName(String name) { this.name = name; }
    public void setOfficeCode(String officeCode) { this.officeCode = officeCode; }
    public void setAddress(Address address) { this.address = address; }
    public void setContact(Contact contact) { this.contact = contact; }
}

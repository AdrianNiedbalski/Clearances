package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "client_id")
    private Integer id;

    /** Pełna nazwa (firmy albo osoby) */
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    /** Relacja do encji Address */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    /** Relacja do encji Contact */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Client() {}

    public Client(Integer id, String name, Address address, Contact contact) {
        this.id = id;
        this.name = name;
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
}

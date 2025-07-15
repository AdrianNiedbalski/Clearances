package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {


    @Id
    @Column(name = "contact_id")
    private Integer id;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 255)
    private String email;

    public Contact() {}

    public Contact(Integer id, String phone, String email) {
        this.id = id;
        this.phone = phone;
        this.email = email;
    }

// --- Gettery i Settery ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

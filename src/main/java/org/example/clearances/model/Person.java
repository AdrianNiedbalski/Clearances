package org.example.clearances.model;
import org.example.clearances.model.Agent;
import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;

    @Column(nullable = false)
    private String role; // np. IMPORTER, EXPORTER, AGENT

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_data_id")
    private LoginData loginData;

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public Contact getContact() { return contact; }

    public void setContact(Contact contact) { this.contact = contact; }

    public LoginData getLoginData() { return loginData; }

    public void setLoginData(LoginData loginData) { this.loginData = loginData; }
}

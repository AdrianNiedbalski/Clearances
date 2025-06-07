package org.example.clearances.model;

import jakarta.persistence.*;
import org.example.clearances.model.LoginData;
import org.example.clearances.model.Person;

@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "login_data_id", nullable = false)
    private LoginData loginData;

    public Agent() {}

    public Agent(Person person, LoginData loginData) {
        this.person = person;
        this.loginData = loginData;
    }

    public Long getId() { return id; }
    public Person getPerson() { return person; }
    public LoginData getLoginData() { return loginData; }
}

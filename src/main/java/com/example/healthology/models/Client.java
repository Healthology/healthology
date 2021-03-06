package com.example.healthology.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class  Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11, columnDefinition = "int(11) unsigned")
    private Long id;
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean agreed_to_terms;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Journal> journals;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @OneToOne(mappedBy = "client_id", cascade = CascadeType.ALL)
    private Client_history client_history;

    @OneToOne(mappedBy = "client_id", cascade = CascadeType.ALL)
    private Client_contact client_contact;

   @ManyToMany (cascade = CascadeType.ALL)
   @JoinTable (
           name= "group_client",
           joinColumns = {@JoinColumn (name = "client_id")},
           inverseJoinColumns = {@JoinColumn(name = "group_id")}
   )
   private List<Group> groups;

    public Client() {}

    public Client(boolean agreed_to_terms, List<Journal> journals, User user_id, Client_history client_history, Client_contact client_contact, List<Group> groups) {
        this.agreed_to_terms = agreed_to_terms;
        this.journals = journals;
        this.user_id = user_id;
        this.client_history = client_history;
        this.client_contact = client_contact;
        this.groups = groups;
    }

    public Client(boolean agreed_to_terms) {
        this.agreed_to_terms = agreed_to_terms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getAgreed_to_terms() {
        return agreed_to_terms;
    }

    public void setAgreed_to_terms(boolean agreed_to_terms) {
        this.agreed_to_terms = agreed_to_terms;
    }

    public User getUser() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }



    public Client_history getClient_history() {
        return client_history;
    }

    public void setClient_history(Client_history client_history) {
        this.client_history = client_history;
    }

    public Client_contact getClient_contact() {
        return client_contact;
    }

    public void setClient_contact(Client_contact client_contact) {
        this.client_contact = client_contact;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
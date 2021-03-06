package com.example.healthology.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;
    @Column(nullable = false, length = 100)
    private String first_name;
    @Column(nullable = false, length = 100)
    private String last_name;
    @Column(nullable = false, length = 200)
    private String profile_img;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 20, unique = true)
    private String phone_number;
    @Column(nullable = false, length = 200, unique = true)
    private String email;
    @Column(nullable = true, columnDefinition = "BLOB")
    private String about_me;
    @Column(nullable = false, length = 100, unique = true)
    private String username;


    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL)
    @JsonIgnore
    private Admin admin;

    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL) //, cascade = CascadeType.ALL)
    @JsonIgnore
    private Client client;

    public User() {}

    public User(String first_name, String last_name, String profile_img, String password, String phone_number,
                String email, String about_me, String username, Client client) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.profile_img = profile_img;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.about_me = about_me;
        this.username = username;
        this.client = client;
    }


    public User(User copy) {
        id = copy.id;
        username = copy.username;
        password = copy.password;
        email = copy.email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String fist_name) {
        this.first_name = fist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}


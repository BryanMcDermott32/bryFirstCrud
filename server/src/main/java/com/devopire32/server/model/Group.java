package com.devopire32.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="user_group")
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    @ManyToOne(cascade= CascadeType.PERSIST)//this is a many to one relationship. cascade type Persist means that the user table is created but is not deleted if the group table is deleted
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//Cascade all signifies that if the Group is deleted then the events should also be deleted
    private Set<Event> events;

}

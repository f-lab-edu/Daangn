package com.example.daangn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "address")
    private List<Post> posts = new ArrayList<>();

    private String si;
    private String gu;
    private String dong;
}


package com.example.daangn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter

public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "address id")
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    private LocalDate createdDate;

    private String name;

    private String nickname;

    private String email;
}
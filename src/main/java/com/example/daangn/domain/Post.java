package com.example.daangn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@NoArgsConstructor
@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages = new ArrayList<>();

    private String title;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

    @Enumerated(EnumType.STRING)
    private SellingStatus status;

    @Builder
    public Post(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}


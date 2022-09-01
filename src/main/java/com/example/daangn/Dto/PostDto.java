package com.example.daangn.Dto;

import com.example.daangn.domain.Address;
import com.example.daangn.domain.SellingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Data
public class PostDto {
    private Long id;
    //private Address address;
    private String title;
    private String content;
}

package com.example.jpa_example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "book_tab")
@Entity
@Setter
@Getter
public class BookEntity extends BaseEntity implements Serializable {
    @Column(name = "bt_name")
    private String bookName;
    @Column(name = "bt_year")
    private Integer bookYear;
}

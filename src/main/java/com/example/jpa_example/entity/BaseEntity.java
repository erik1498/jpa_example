package com.example.jpa_example.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "uuid", updatable = false, nullable = false)
    private String uuid = UUID.randomUUID().toString();

    @CreationTimestamp
    @Column(name = "bt_created_date", nullable = false, updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "bt_modified_date", nullable = false)
    private Date modifiedDate;
}

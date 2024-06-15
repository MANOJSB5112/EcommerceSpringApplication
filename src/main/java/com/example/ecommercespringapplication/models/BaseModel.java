package com.example.ecommercespringapplication.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
    private Date lastCreatedAt;
    private Date lastUpdatedAt;
    private Boolean isDeleted;

}

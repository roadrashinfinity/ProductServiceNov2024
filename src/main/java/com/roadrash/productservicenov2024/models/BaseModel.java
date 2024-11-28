package com.roadrash.productservicenov2024.models;

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
    private long id;
    private Date created_at;
    private Date updated_at;
    private boolean deleted;


}

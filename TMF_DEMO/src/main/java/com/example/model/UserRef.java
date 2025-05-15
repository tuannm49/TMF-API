package com.example.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserRef {
    private String id;
    private String name;
}

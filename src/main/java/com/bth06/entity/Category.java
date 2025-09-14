package com.bth06.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="categoryName", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String categoryName;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String images;
}

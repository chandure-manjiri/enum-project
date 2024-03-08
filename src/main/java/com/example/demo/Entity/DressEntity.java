package com.example.demo.Entity;

import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dress")
public class DressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "dress_color")
    private DressColor dressColor;

    @Enumerated(EnumType.STRING)
    @Column(name = "dress_size")
    private DressSize dressSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "dress_type")
    private DressType dressType;

    @Column(name = "price")
    private Long price;
}

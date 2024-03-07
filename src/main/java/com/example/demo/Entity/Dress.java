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
@Table(name = "dresses")
public class Dress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "dressColor")
    private DressColor dressColor;

    @Enumerated(EnumType.STRING)
    @Column(name = "dressSize")
    private DressSize dressSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "dressType")
    private DressType dressType;

    @Column(name = "price")
    private Long price;
}

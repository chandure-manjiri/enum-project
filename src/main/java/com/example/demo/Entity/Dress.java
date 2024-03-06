package com.example.demo.Entity;

import com.example.demo.Enums.DressColor;
import com.example.demo.Enums.DressSize;
import com.example.demo.Enums.DressType;
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
    private Integer id;

    private String name;

    private String brand;

    @Enumerated(EnumType.STRING)
    private DressColor color;

    @Enumerated(EnumType.STRING)
    private DressSize size;

    @Enumerated(EnumType.STRING)
    private DressType type;
}

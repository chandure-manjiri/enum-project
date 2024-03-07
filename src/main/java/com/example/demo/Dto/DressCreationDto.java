package com.example.demo.Dto;

import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DressCreationDto {

    private String name;

    private String brand;

    @Enumerated(EnumType.STRING)
    private DressColor color;


    private int size;

    @Enumerated(EnumType.STRING)
    private DressType type;

    private Long price;
}

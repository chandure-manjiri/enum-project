package com.example.demo.Dto;

import com.example.demo.Enums.DressColor;
import com.example.demo.Enums.DressSize;
import com.example.demo.Enums.DressType;
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

    @Enumerated(EnumType.STRING)
    private DressSize size;

    @Enumerated(EnumType.STRING)
    private DressType type;
}

package com.example.demo.Dto;

import com.example.demo.Enums.DressColor;
import com.example.demo.Enums.DressSize;
import com.example.demo.Enums.DressType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DressResponseDto {
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

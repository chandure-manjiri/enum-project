package com.example.demo.Dto;

import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
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

    private Long price;
}

package com.example.demo.Mapper;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Entity.Dress;
import com.example.demo.Enum.DressSize;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DressMapper {

    @Mapping(source ="name" , target ="name")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "size", target = "size", expression = "java(convertToDressSizeEnum(dressCreationDto.getSize()))")
    public Dress toEntity(DressCreationDto dressCreationDto);

    default DressSize convertToDressSizeEnum(int size){
        DressSize dressSize = null;
        if(size > 0 & size <= 30){
                dressSize = DressSize.S;
        }
        else if(size > 30 & size <= 49){
                dressSize = DressSize.M;
        }
        else if(size >= 50){
               dressSize = DressSize.L;
        }
        return dressSize;
    }

    @Mapping(source ="name" , target ="name")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "size", target = "size")
    public DressResponseDto toDto(Dress dress);

}

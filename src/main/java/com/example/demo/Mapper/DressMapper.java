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
    @Mapping(source = "price", target = "price")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "color", target = "color")
    @Mapping(target = "size", expression = "java(convertToDressSizeEnum(dressCreationDto.getSize()))")
    public Dress toEntity(DressCreationDto dressCreationDto);

    default DressSize convertToDressSizeEnum(int size){
       return DressSize.convertToEnum(size);
    }

    @Mapping(source ="name" , target ="name")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "size", target = "size")
    public DressResponseDto toDto(Dress dress);

}

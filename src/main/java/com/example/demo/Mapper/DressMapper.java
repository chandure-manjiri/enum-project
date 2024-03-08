package com.example.demo.Mapper;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Entity.DressEntity;
import com.example.demo.Entity.DressEntity;
import com.example.demo.Enum.DressSize;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DressMapper {

    @Mapping(source ="name" , target ="name")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "type", target = "dressType")
    @Mapping(source = "color", target = "dressColor")
    @Mapping(target = "dressSize", expression = "java(convertToDressSizeEnum(dressCreationDto.getSize()))")
    public DressEntity toEntity(DressCreationDto dressCreationDto);

    default DressSize convertToDressSizeEnum(int size){
       return DressSize.convertToEnum(size);
    }

    @Mapping(source ="name" , target ="name")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "dressType", target = "type")
    @Mapping(source = "dressColor", target = "color")
    @Mapping(source = "dressSize", target = "size")
    public DressResponseDto toDto(DressEntity dress);

    List<DressResponseDto> toDressResponseDtoList(List<DressEntity> dresses);

}

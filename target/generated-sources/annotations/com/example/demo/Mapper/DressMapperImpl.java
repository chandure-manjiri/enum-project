package com.example.demo.Mapper;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Entity.DressEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-07T17:48:55+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Private Build)"
)
@Component
public class DressMapperImpl implements DressMapper {

    @Override
    public DressEntity toEntity(DressCreationDto dressCreationDto) {
        if ( dressCreationDto == null ) {
            return null;
        }

        DressEntity dressEntity = new DressEntity();

        dressEntity.setName( dressCreationDto.getName() );
        dressEntity.setBrand( dressCreationDto.getBrand() );
        dressEntity.setPrice( dressCreationDto.getPrice() );
        dressEntity.setDressType( dressCreationDto.getType() );
        dressEntity.setDressColor( dressCreationDto.getColor() );

        dressEntity.setDressSize( convertToDressSizeEnum(dressCreationDto.getSize()) );

        return dressEntity;
    }

    @Override
    public DressResponseDto toDto(DressEntity dress) {
        if ( dress == null ) {
            return null;
        }

        DressResponseDto dressResponseDto = new DressResponseDto();

        dressResponseDto.setName( dress.getName() );
        dressResponseDto.setBrand( dress.getBrand() );
        dressResponseDto.setPrice( dress.getPrice() );
        dressResponseDto.setType( dress.getDressType() );
        dressResponseDto.setColor( dress.getDressColor() );
        dressResponseDto.setSize( dress.getDressSize() );
        dressResponseDto.setId( dress.getId() );

        return dressResponseDto;
    }

    @Override
    public List<DressResponseDto> toDressResponseDtoList(List<DressEntity> dresses) {
        if ( dresses == null ) {
            return null;
        }

        List<DressResponseDto> list = new ArrayList<DressResponseDto>( dresses.size() );
        for ( DressEntity dressEntity : dresses ) {
            list.add( toDto( dressEntity ) );
        }

        return list;
    }
}

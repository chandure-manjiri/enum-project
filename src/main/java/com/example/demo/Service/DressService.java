package com.example.demo.Service;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Entity.Dress;
import com.example.demo.Mapper.DressMapper;
import com.example.demo.Repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DressService {


    private final DressMapper dressMapper;

    private final DressRepository dressRepository;

    @Autowired
    public DressService(DressMapper dressMapper, DressRepository dressRepository) {
        this.dressMapper = dressMapper;
        this.dressRepository = dressRepository;
    }


    public DressResponseDto createDress(DressCreationDto dressCreationDto){
        Dress dress = this.dressMapper.toEntity(dressCreationDto);
        this.dressRepository.save(dress);
        return this.dressMapper.toDto(dress);
    }
}

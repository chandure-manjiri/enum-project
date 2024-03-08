package com.example.demo.Service;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Entity.DressEntity;
import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
import com.example.demo.Mapper.DressMapper;
import com.example.demo.Repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {

    @Autowired
    private  DressMapper dressMapper;

    @Autowired
    private DressRepository dressRepository;




    public DressResponseDto createDress(DressCreationDto dressCreationDto){
        DressEntity dress = this.dressMapper.toEntity(dressCreationDto);
        this.dressRepository.save(dress);
        return this.dressMapper.toDto(dress);
    }
    public List<DressResponseDto> findByDresstypeAndSizeAndColor(DressType dressType, DressSize dressSize, DressColor dressColor){
        List<DressEntity> dressList = this.dressRepository.findByDressTypeAndDressSizeAndDressColor(dressType, dressSize,dressColor);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> findByDresstypeAndSizeOrPrice(DressType dressType, DressSize dressSize, Long price){
        List<DressEntity> dressList = this.dressRepository.findByDressTypeAndDressSizeOrPrice(dressType, dressSize, price);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> findByDressColorNot(DressColor dressColor){
        List<DressEntity> dressList = this.dressRepository.findByDressColorNot(dressColor);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> findByPriceBetween(Long price1, Long price2){
        List<DressEntity> dressList = this.dressRepository.findByPriceBetween(price1, price2);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> findByBrandIn(String[] brands){
        List<DressEntity> dressList = this.dressRepository.findByBrandIn(brands);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> findByPriceGreaterThan(Long price){
        List<DressEntity> dressList = this.dressRepository.findByPriceGreaterThan(price);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> findByPriceLessThan(Long price){
        List<DressEntity> dressList = this.dressRepository.findByPriceLessThan(price);
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

    public List<DressResponseDto> getAllDresses(){
        List<DressEntity> dressList = this.dressRepository.findAll();
        return this.dressMapper.toDressResponseDtoList(dressList);
    }

}

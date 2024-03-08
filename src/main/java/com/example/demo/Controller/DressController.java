package com.example.demo.Controller;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
import com.example.demo.Service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DressController {

   private final DressService dressService;
    @Autowired
    public DressController(DressService dressService) {
        this.dressService = dressService;
    }

    @PostMapping("/dresses")
    ResponseEntity<DressResponseDto> createDress(@RequestBody DressCreationDto dressCreationDto){
        DressResponseDto dressResponseDto = this.dressService.createDress(dressCreationDto);
        return new ResponseEntity<>(dressResponseDto, HttpStatus.CREATED);

    }

    @GetMapping("/dresses")
    ResponseEntity<List<DressResponseDto>> getDressList(
            @RequestParam(name = "type", required = false) DressType dressType,
            @RequestParam(name = "size", required = false)DressSize dressSize,
            @RequestParam(name = "color", required = false)DressColor dressColor,
            @RequestParam(name = "brand", required = false)String[] brands,
            @RequestParam(name = "price", required = false)Long price,
            @RequestParam(name = "excludedColor",required = false)DressColor excludedColor,
            @RequestParam(name = "maxPrice", required = false)Long maxPrice,
            @RequestParam(name = "minPrice", required = false)Long minPrice
                                                                          ){

        List<DressResponseDto> dressResponseDtoList = null;
        if(dressType != null && dressSize != null && dressColor != null){
            dressResponseDtoList = this.dressService.findByDresstypeAndSizeAndColor(dressType, dressSize, dressColor);
        }
        else if(dressType != null && dressSize != null || price !=null){
            dressResponseDtoList = this.dressService.findByDresstypeAndSizeOrPrice(dressType,dressSize,price);
        }
        else if(excludedColor != null){
            dressResponseDtoList = this.dressService.findByDressColorNot(excludedColor);
        }
        else if(minPrice != null & maxPrice != null){
            dressResponseDtoList = this.dressService.findByPriceBetween(minPrice, maxPrice);
        }
        else if(brands != null){
            dressResponseDtoList = this.dressService.findByBrandIn(brands);
        }
        else if (minPrice!= null) {
            dressResponseDtoList = this.dressService.findByPriceGreaterThan(minPrice);
        }
        else if(maxPrice != null){
            dressResponseDtoList = this.dressService.findByPriceLessThan(maxPrice);
        }
        else{
            dressResponseDtoList = this.dressService.getAllDresses();
        }
        return new ResponseEntity<>(dressResponseDtoList, HttpStatus.OK);
    }


}

package com.example.demo.Controller;

import com.example.demo.Dto.DressCreationDto;
import com.example.demo.Dto.DressResponseDto;
import com.example.demo.Service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DressController {
   @Autowired
   private final DressService dressService;

    public DressController(DressService dressService) {
        this.dressService = dressService;
    }

    @PostMapping("/dresses")
    ResponseEntity<DressResponseDto> createDress(@RequestBody DressCreationDto dressCreationDto){
        DressResponseDto dressResponseDto = this.dressService.createDress(dressCreationDto);
        return new ResponseEntity<>(dressResponseDto, HttpStatus.CREATED);

    }

}

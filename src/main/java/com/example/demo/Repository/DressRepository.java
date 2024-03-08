package com.example.demo.Repository;

import com.example.demo.Entity.DressEntity;
import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends JpaRepository<DressEntity, Integer> {
    List<DressEntity> findByDressTypeAndDressSizeAndDressColor(DressType dressType, DressSize dressSize, DressColor dressColor);
    List<DressEntity> findByDressTypeAndDressSizeOrPrice(DressType dressType, DressSize dressSize, Long price);

    List<DressEntity> findByDressColorNot(DressColor dressColor);

    List<DressEntity> findByPriceBetween(Long price1, Long price2);

    List<DressEntity> findByBrandIn(String[] brands);

    List<DressEntity> findByPriceGreaterThan(Long price);

    List<DressEntity> findByPriceLessThan(Long price);


}

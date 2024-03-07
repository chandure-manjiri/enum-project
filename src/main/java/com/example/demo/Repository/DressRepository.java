package com.example.demo.Repository;

import com.example.demo.Entity.Dress;
import com.example.demo.Enum.DressColor;
import com.example.demo.Enum.DressSize;
import com.example.demo.Enum.DressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends JpaRepository<Dress, Integer> {
    List<Dress> findByDresstypeAndSizeAndColor(DressType dressType, DressSize dressSize, DressColor dressColor);
    List<Dress> findByDresstypeAndSizeOrColor(DressType dressType, DressSize dressSize, DressColor dressColo);

    List<Dress> findByColorNot(DressColor dressColor);

    List<Dress> findByPriceBetween(Long price1, Long price2);

    List<Dress> findByBrandIn(String[] brands);

    List<Dress> findBySizeGreaterThan(DressSize dressSize);

    List<Dress> findByPriceLessThan(Long price);


}

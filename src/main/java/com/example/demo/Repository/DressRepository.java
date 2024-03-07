package com.example.demo.Repository;

import com.example.demo.Entity.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DressRepository extends JpaRepository<Dress, Integer> {
}

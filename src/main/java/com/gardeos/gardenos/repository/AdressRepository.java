package com.gardeos.gardenos.repository;

import com.gardeos.gardenos.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Long> {
    List<Adress> findAllByClientId(Long clientId);
}

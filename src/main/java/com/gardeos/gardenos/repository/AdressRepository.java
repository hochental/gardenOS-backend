package com.gardeos.gardenos.repository;

import com.gardeos.gardenos.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Long> {
    List<Adress> findAllByClientId(Long clientId);
    @Query(value = "SELECT client_id FROM adress a WHERE a.id= :adressId",
            nativeQuery = true)
    Long findIdOfClient(@Param("adressId") Long adressId);

    @Query(value = "SELECT id FROM adress a WHERE a.client_id= :clientId",
            nativeQuery = true)
    List<Long> findAllIdAdress(@Param("clientId") Long clientId);

}

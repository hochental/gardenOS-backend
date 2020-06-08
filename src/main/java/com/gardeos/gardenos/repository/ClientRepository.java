package com.gardeos.gardenos.repository;

import com.gardeos.gardenos.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByTelephoneNumber(String telephoneNumber);
    Optional<Client> findByEmail(String email);

}

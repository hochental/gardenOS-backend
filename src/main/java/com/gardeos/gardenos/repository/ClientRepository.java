package com.gardeos.gardenos.repository;

import com.gardeos.gardenos.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

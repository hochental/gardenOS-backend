package com.gardeos.gardenos.paggination;

import com.gardeos.gardenos.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepositoryPaggination extends PagingAndSortingRepository<Client, Long> {
}

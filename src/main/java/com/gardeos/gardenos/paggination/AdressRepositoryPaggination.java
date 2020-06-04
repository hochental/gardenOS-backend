package com.gardeos.gardenos.paggination;

import com.gardeos.gardenos.entity.Adress;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdressRepositoryPaggination extends PagingAndSortingRepository<Adress, Long> {
}

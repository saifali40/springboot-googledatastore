package com.scheduling.j11.repository;

import com.scheduling.j11.entities.Books;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import java.util.List;


public interface BookRepository extends DatastoreRepository<Books, String> {

    List<Books> findByBrand(String brand);
    List<Books> findByBrandAndMerchantId(String brand, String merchantId);
    List<Books> findByMerchantId(String merchantId);
}

package com.example.springapitest.repository;

import com.example.springapitest.model.Merchant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Integer> {

   // @Query(value = "select * from merchants", nativeQuery =  true)
    List<Merchant> findAll ();
    Optional<Merchant> findById (Integer id);
}

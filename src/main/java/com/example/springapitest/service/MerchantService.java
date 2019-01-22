package com.example.springapitest.service;

import com.example.springapitest.model.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    List<Merchant> findAll ();

    Optional<Merchant> findById(Integer id);

}

package com.example.springapitest.controller;

import com.example.springapitest.exception.merchanr.MerchantNotFoundException;
import com.example.springapitest.model.Merchant;
import com.example.springapitest.service.MerchantService;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(tags = "Merchants Rest Controller")
public class MerchantController {

    private static Logger LOG = LogManager.getLogger(MerchantController.class);
    private MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @RequestMapping(value = "/merchants", method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Get all merchants", tags = "Merchant Rest Controller")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    public ResponseEntity<List<Merchant>> getAllMerchants(){

        List<Merchant> merchants = merchantService.findAll();
        if(merchants.isEmpty()){
            LOG.info("Response {}", merchants);
            return new ResponseEntity<>(merchants, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(merchants, HttpStatus.OK);
    }

    @RequestMapping(value = "/merchant/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Get Merchant detail", tags = "Merchant Rest Controller")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error") })
    public ResponseEntity<Optional<Merchant>> getMerchantDetail (@PathVariable("id") Integer id)
    throws MerchantNotFoundException {
        Optional<Merchant> merchant = merchantService.findById(id);
        if(merchant.isPresent()){
            return new ResponseEntity<>(merchant,HttpStatus.OK);
        }else {
            throw new MerchantNotFoundException();
        }

    }

}

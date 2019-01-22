package com.example.springapitest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.AttributeConverter;

public class ConvertObject implements AttributeConverter<Object, String> {

    private static final Logger logger = LogManager.getLogger(ConvertObject.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object meta) {
        try {
            if(meta == null){
                return null;
            }else
            return objectMapper.writeValueAsString(meta);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
//            ex.printStackTrace();
//            logger.debug("------------"+ex.getMessage());
        }
    }
    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            if(dbData == null){
                return null;
            }else
                return objectMapper.readValue(dbData, Object.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dbData;
    }
}
package com.profuturo.edocta.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.profuturo.edocta.demo.excepciones.UnknownResourceServiceException;
import com.profuturo.edocta.demo.servicio.impl.EdoCtaServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilConversor  {
    private static final Logger logger = LogManager.getLogger(UtilConversor.class);

    public String parseToJson(Object object) {
        try {

            // ObjectMapper mapper = new ObjectMapper();
            // String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

            StringBuilder strb = new StringBuilder();
            strb.append("\n");
            strb.append(new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(object));

            return strb.toString();

        } catch (Exception ex) {
            // falta agregar un error global
            logger.error(ex.getMessage());
            throw new UnknownResourceServiceException(ex.getMessage());

        }

    }
}

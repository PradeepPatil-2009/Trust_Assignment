package com.example.clientapp2.service;

import java.io.StringWriter;

import org.springframework.stereotype.Service;

import com.example.clientapp2.xmlRequest.TxnRequestXml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

@Service
public class JsonToXmlConverter {

    public String convertToXml(TxnRequestXml xmlObj) {
        try {
            JAXBContext context = JAXBContext.newInstance(TxnRequestXml.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(xmlObj, writer);
            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException("XML conversion failed", e);
        }
    }
}

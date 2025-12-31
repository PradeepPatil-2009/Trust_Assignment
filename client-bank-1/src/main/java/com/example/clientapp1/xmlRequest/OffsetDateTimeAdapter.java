package com.example.clientapp1.xmlRequest;

import java.time.OffsetDateTime;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class OffsetDateTimeAdapter
        extends XmlAdapter<String, OffsetDateTime> {

    @Override
    public OffsetDateTime unmarshal(String value) {
        return value == null ? null : OffsetDateTime.parse(value);
    }

    @Override
    public String marshal(OffsetDateTime value) {
        return value == null ? null : value.toString();
    }
}

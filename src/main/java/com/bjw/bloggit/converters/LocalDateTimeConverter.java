package com.bjw.bloggit.converters;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
        }
        return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        if (date != null) {
            return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        }
        return null;
    }

}

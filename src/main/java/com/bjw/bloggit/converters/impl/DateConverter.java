package com.bjw.bloggit.converters.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.bjw.bloggit.converters.IDateConverter;

@Service
public class DateConverter implements IDateConverter {

    @Override
    public LocalDateTime convertLongToLocalDateTime(Long epoch) {
        if (epoch != null) {
            Instant epochDate = Instant.ofEpochMilli(epoch);
            return LocalDateTime.ofInstant(epochDate, ZoneOffset.UTC);
        }
        return null;
    }

    @Override
    public Long convertLocalDateTimeToLong(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            OffsetDateTime zdt = localDateTime.atOffset(ZoneOffset.UTC);
            return zdt.toInstant().toEpochMilli();
        }
        return null;
    }

}

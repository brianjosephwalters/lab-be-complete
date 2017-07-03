package com.bjw.bloggit.converters.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.bjw.bloggit.converters.IDateConverter;

public class DateConverterTest {
    
    private IDateConverter dateConverter = new DateConverter();
    
    @Test
    public void testConvertLongToLocalDateTime() {
        Long epoch = 1483682400000L;    // 01/06/2017
        LocalDateTime localDateTime = dateConverter.convertLongToLocalDateTime(epoch);
        assertThat(localDateTime.getYear(), is(equalTo(2017)));
        assertThat(localDateTime.getMonthValue(), is(equalTo(1)));
        assertThat(localDateTime.getDayOfMonth(), is(equalTo(6)));
    }
    
    @Test
    public void testConvertingLongToLocalDateTime_NullEpoch() {
        Long epoch = null;
        LocalDateTime localDateTime = dateConverter.convertLongToLocalDateTime(epoch);
        assertThat(localDateTime, is(equalTo(null)));
    }

    @Test
    public void testConvertLocalDateTimeToLong() {
        LocalDateTime localDateTime = LocalDateTime.of(2017, 1, 6, 0, 0);
        Long epoch = dateConverter.convertLocalDateTimeToLong(localDateTime);
        assertThat(epoch, is(equalTo(1483660800000L)));
    }
    
    @Test
    public void testConvertLocalDateTimeToLong_NullLocalDateTime() {
        LocalDateTime localDateTime = null;
        Long epoch = dateConverter.convertLocalDateTimeToLong(localDateTime);
        assertThat(epoch, is(equalTo(null)));
    }

}

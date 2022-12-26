package com.example.EcommerceWithSpringDataJpa.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtils {

    public Date convertStringToDate(String dateString){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public LocalDate dateYearsAgo(int years){
        LocalDate today = LocalDate.now();
        return today.minusYears(years);
    }

    public Date changeFormat(String format, Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return convertStringToDate(dateFormat.format(date));
    }

    public String convertDateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

}

package com.airtribe.meditrack.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String format(LocalDate date){
        return date.format(formater);
    }

    public static LocalDate parse(String date){
        return LocalDate.parse(date, formater);
    }
}

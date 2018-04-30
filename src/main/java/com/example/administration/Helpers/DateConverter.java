package com.example.administration.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter
{
    public static Date getDateFrom(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch(ParseException eP) {
            eP.printStackTrace();
        }
        return null;
    }
}

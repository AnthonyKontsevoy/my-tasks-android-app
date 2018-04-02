package com.anthonyestacado.mytasks.common;

import android.icu.text.SimpleDateFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class MyUtils {

    public static String selectOnlyDateFromString(String inputString) {

        StringBuilder stringBuilder = new StringBuilder(inputString);

        //Get a position of space symbol for further splitting a whole string into a date and time
        int commaPosition = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (stringBuilder.charAt(i) == ',') {
                commaPosition = i;
                break;
            }
        }

        //Cut a date to the format "Mar 15"
        String dateShort = stringBuilder.substring(0, commaPosition);


//        String month = stringBuilder.substring(5, 7);
//        switch (month) {
//            case "01": {
//                month = "Jan";
//                break;
//            }
//            case "02": {
//                month = "Feb";
//                break;
//            }
//            case "03": {
//                month = "Mar";
//                break;
//            }
//            case "04": {
//                month = "Apr";
//                break;
//            }
//            case "05": {
//                month = "May";
//                break;
//            }
//            case "06": {
//                month = "Jun";
//                break;
//            }
//            case "07": {
//                month = "Jul";
//                break;
//            }
//            case "08": {
//                month = "Aug";
//                break;
//            }
//            case "09": {
//                month = "Sep";
//                break;
//            }
//            case "10": {
//                month = "Oct";
//                break;
//            }
//            case "11": {
//                month = "Nov";
//                break;
//            }
//            case "12": {
//                month = "Dec";
//                break;
//            }
//        }
//        String convertedDate = month + " " + stringBuilder.substring(8, 10);

        //There's a comma before the last space symbol so we should delete it from the date string too by using "lastSpacePosition - 1" as an index of the end of date string

        return dateShort;
    }

    public static String selectOnlyTimeFromString(String inputString) {


        StringBuilder stringBuilder = new StringBuilder(inputString);

        //Get a position of space symbol for further splitting a whole string into a date and time
        int commaPosition = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (stringBuilder.charAt(i) == ',') {
                commaPosition = i;
                break;
            }
        }

        return stringBuilder.substring(commaPosition + 5, inputString.length() - 1);
    }

}

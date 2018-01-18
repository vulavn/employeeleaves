package com.employee.utility;

import org.springframework.validation.ObjectError;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Common {

    public static List<String> createErrorMessage(List<ObjectError> listError) {

        if (null == listError || listError.isEmpty()) {
            return null;
        }

        List<String> listMessage = new ArrayList<>();
        for (ObjectError error : listError) {
            listMessage.add(error.getDefaultMessage());
        }
        return listMessage;
    }

    public static Date formatDateToDate(Date date, String format) throws Exception {

        // Create format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        // Convert Date to String
        String strDate = simpleDateFormat.format(date);

        // Convert String to Date with new format
        Date formatDate = simpleDateFormat.parse(strDate);

        return formatDate;
    }

    public static int getHour(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getYear(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    public static long subtract2Date(Date date1, Date date2) {

        long diff = Math.abs(date1.getTime() - date2.getTime());
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;
    }

    /**
     * duration = subtractDate + dayOffByHour
     *
     * @param subtractDate
     * @param subtractHour
     * @return int
     */
    public static double countDuration(long subtractDate, int subtractHour) {

        double dayOffByHour = 0;
        switch (subtractHour) {

            case 4:
            case 5:
                dayOffByHour = 0.5;
                break;
            case 9:
                dayOffByHour = 1;
                break;
        }
        double duration = subtractDate + dayOffByHour;

        return duration;
    }

    public static Date convertStringToDate(String strDate, String format) throws Exception {

        if (strDate == null || strDate.isEmpty()) {
            return null;
        }

        // Create format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        // Convert String to Date with new format
        Date formatDate = simpleDateFormat.parse(strDate);

        return formatDate;
    }
}

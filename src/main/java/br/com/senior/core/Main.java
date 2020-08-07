package br.com.senior.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static String[] formats = new String[]{"", ""};

    public static void main(String[] args) {
        String[] toConvert = new String[]{"2020-05-03", "2020-05-03T12:55:22.501Z"};
        for (String convert : toConvert) {
            System.out.println(tryParse(convert).toString());
        }
    }

    private static Date tryParse(String strDate) {
        for (String format : formats) {
            try {
                return new SimpleDateFormat(format).parse(strDate);
            } catch (ParseException e) {
            }
        }
        return null;

    }

}


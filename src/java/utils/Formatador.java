/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gustavo Calandrini
 */
public class Formatador {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String formataData(Date date) {
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String stringDate) throws ParseException {
        return simpleDateFormat.parse(stringDate);
    }

}

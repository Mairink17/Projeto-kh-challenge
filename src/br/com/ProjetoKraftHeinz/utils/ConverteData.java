package br.com.ProjetoKraftHeinz.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConverteData {


    public static String convertFromSQLDateToJAVADate(
            Date sqlDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new java.sql.Date(sqlDate.getTime());
        }
        return  format.format(javaDate);
    }

    public static String convertFromJAVADateToSQLDate(
            java.util.Date javaDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");


            javaDate = new java.sql.Date(javaDate.getTime());

        return  format.format(javaDate);
    }
}

package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversoes {
    
    public static String getDateToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
    
    public static String getDatetimeToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
    }
   
    public static String getTimeToString(Date horario){
        return new SimpleDateFormat("HH:mm").format(horario);
    }
    
    public static Date getStringToTime(String param) {
        Date date;
        try {
            date = new SimpleDateFormat("HH:mm").parse(param);
        } catch (ParseException ex) {
            date = new Date();
        }
        
        return date;
    }
    
    public static Date getStringToDate(String param) {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyyy").parse(param);
        } catch (ParseException ex) {
            date = new Date();
           
        }
        return date;
    }
    
    public static Date getStringToDatetime(String param) {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyyy HH:mm").parse(param);
        } catch (ParseException ex) {
            date = new Date();
           
        }
        return date;
    }
    
    public static Date somaData(Date data, int somaDias)
    {
        Date dt = data;
        dt.setDate(dt.getDate() + somaDias);        
        return dt;
    }
   
    
}
package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utility {


    public int getNumbersFromText(String txt) {
        return Integer.parseInt(txt.replaceAll("[^0-9]", ""));
    }
    public  String getCurrentDate(String format)
    {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }
}

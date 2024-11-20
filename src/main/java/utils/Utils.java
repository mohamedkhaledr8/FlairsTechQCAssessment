package utils;

public class Utils {


    public int getNumbersFromText(String txt) {
        return Integer.parseInt(txt.replaceAll("[^0-9]", ""));
    }
}

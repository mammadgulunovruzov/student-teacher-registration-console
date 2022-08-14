public class StringUtility {

    public static boolean containsIgnoreCase(String val1, String val2   ){

        return val1.toLowerCase().contains(val2.toLowerCase());
    }

    public static boolean checkIntegers(Integer val1, Integer val2) {
        return val1.equals(val2);

    }

    public static boolean checkDoubles(Double val1, Double val2){
        return val1.equals(val2);
    }



}

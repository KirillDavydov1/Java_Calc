import java.util.HashMap;
import java.util.Map;

public class Converter {
    static Map<String, Integer> map = new HashMap<>() {{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};

    static int[] roman_value_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] roman_char_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String fromArabToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i++) {
            while (num >= roman_value_list[i]) {
                num -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        return res.toString();
    }

    public static int[] fromRomanToArab(String a, String b) {
        return new int[]{map.get(a), map.get(b)};
    }
}

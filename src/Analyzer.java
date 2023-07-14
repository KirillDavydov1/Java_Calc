import java.util.Set;
import java.util.regex.Pattern;

public class Analyzer {

    private static Set<String> romansNum = Set.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    public Analyzer() {

    }

    public static int[] analyze(String a, String b, String c) throws Exception {

        if (Pattern.matches(("\\d"), a) && Pattern.matches(("\\d"), b)) {
            return new int[]{Integer.parseInt(a), Integer.parseInt(b)};
        }
        // операция для арабского и римского числа
        if (Pattern.matches(("\\d"), a) && romansNum.contains(b) ||
                Pattern.matches(("\\d"), b) && romansNum.contains(a)) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        // операция для двух римских чисел
        if (romansNum.contains(a) && romansNum.contains(b)) {
            if (c.equals("-")) {
                if (Converter.fromRomanToArab(a, b)[0] > Converter.fromRomanToArab(a, b)[1]) {
                    return Converter.fromRomanToArab(a, b);
                } else {
                    throw new Exception("В римской системе счисления нет отрицательных чисел");
                }
            } else {
                return Converter.fromRomanToArab(a, b);
            }
        }
        throw new Exception("Вы ввели какую-то херню");
    }

    public static Set<String> getRomansNum() {
        return romansNum;
    }
}

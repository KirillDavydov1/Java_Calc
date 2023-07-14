import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        calc("1 / 9");
    }

    public static String calc(String input) throws Exception {

        String s = input;
        String[] symbol = s.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)

        if (symbol.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию -" +
                    " два операнда и один оператор (+, -, /, *)");
        }
        if (symbol.length < 3) {
            throw new Exception("Строка не является математической операцией");
        }

        int[] digit = Analyzer.analyze(symbol[0], symbol[2], symbol[1]);
        int result;

        switch (symbol[1]) {
            case ("+") -> result = Arythmetic.summation(digit[0], digit[1]);
            case ("-") -> result = Arythmetic.substraction(digit[0], digit[1]);
            case ("/") -> result = Arythmetic.division(digit[0], digit[1]);
            case ("*") -> result = Arythmetic.multiplication(digit[0], digit[1]);
            default -> throw new IllegalStateException("Unexpected value: " + symbol[1]);
        }

        if (Analyzer.getRomansNum().contains(symbol[0])) {
            //то переводим результат в римскую систему счисления, надо дописать этот метод в конвертере
            System.out.println(Converter.fromArabToRoman(result));
            return Converter.fromArabToRoman(result);
        } else {
            //выводим результат как есть
            System.out.println(result);
            return Integer.toString(result);
        }

    }

}

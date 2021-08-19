package org.example.calculate;

public class RymNumber {
    static final String[] arrRymDigits = new String[] {
            "", "I", "II", "III", "IV", "V",
            "VI", "VII", "VIII", "IX", "X"
    };

    private static final String[] arrRymDozens  = new String[] {
            "", "X", "XX", "XXX", "XL", "L",
            "LX", "LXX", "LXXX", "XC", "C"
    };

    // Данный метод нужен для чисел от 1 до 10. Если число не входит в данный диапазон возвращается 0
    static public int parseInt(String number) {
        for(int i = 1; i < arrRymDigits.length; i++) {
            if(number.equals(arrRymDigits[i])) {
                return i;
            }
        }
        return 0;
    }

    // Данный метод написан для чисел от 1 до 100 включительно
    public static String parseRym(int val) {
        return arrRymDozens[val/10]+arrRymDigits[val%10];
    }

}

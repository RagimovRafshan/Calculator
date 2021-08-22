package org.example.calculate;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final char[] operands = new char[]{
            '+',
            '-',
            '/',
            '*'
    };
    public String toSalve(String example) {
        try {
            char operand = ' ';
            int countOperands = 0;
            int indexOperand = -1;
            for (int i = 0; i < operands.length; i++) {
                int placeOperand = example.indexOf(operands[i]);
                if (placeOperand != -1) {
                    if (countOperands != 0) {
                        throw new Exception();
                    }
                    indexOperand = placeOperand;
                    countOperands++;
                    operand = operands[i];
                }
            }
            if (indexOperand == -1 || indexOperand != example.lastIndexOf(operand)) {
                throw new Exception();
            }

            String[] arr = splitByIndex(example, indexOperand);
            boolean arabyNumbs = false;
            int a;
            int b;
            try {
                a = Integer.parseInt(arr[0]);
                arabyNumbs = true;
                b = Integer.parseInt(arr[2]);

            } catch (NumberFormatException e) {
                b = RomanNumber.parseInt(arr[2]);
                if (arabyNumbs) {
                    throw new Exception();
                }
                a = RomanNumber.parseInt(arr[0]);
                if (a == 0 || b == 0) {
                    throw new Exception();
                }
            }

            if (!(limit(a) && limit(b))) {
                throw new Exception();
            }

            int answer;
            switch (operand) {
                case '+':
                    answer = a + b;
                    break;
                case '-':
                    answer = a - b;
                    break;
                case '/':
                    answer = a / b;
                    break;
                case '*':
                    answer = a * b;
                    break;
                default:
                    throw new Exception();
            }

            if(arabyNumbs) {
                return String.valueOf(answer);
            } else {
                return RomanNumber.parseRym(answer);
            }
        } catch(Exception ex) {
            return ex.toString();
        }
    }

    private String[] splitByIndex(String example, int index) {
        char[] a = new char[index];
        char[] b = new char[example.length()-(index+1)];
        for(int i = 0; i < index; i++) {
            a[i] = example.charAt(i);
        }
        int indexB = 0;
        for(int i = index+1; i < example.length(); i++) {
            b[indexB] = example.charAt(i);
            indexB++;
        }
        return new String[]{
                String.valueOf(a),
                String.valueOf(example.charAt(index)),
                String.valueOf(b)
        };
    }

    public static boolean limit(int numb) {
        return numb>0 && numb<11;
    }

}

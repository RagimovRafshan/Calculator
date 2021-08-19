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
        char operand = ' ';
        int countOperands = 0;
        int indexOperand = -1;
        for (int i = 0; i < operands.length; i++) {

            int placeOperand = example.indexOf(operands[i]);
            if (placeOperand != -1) {
                if (countOperands != 0) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        return e.toString();
                    }
                }
                indexOperand = placeOperand;
                countOperands++;
                operand = operands[i];
            }
        }
        if(indexOperand == -1 || indexOperand != example.lastIndexOf(operand)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return e.toString();
            }
        }
        String[] arr = splitByIndex(example, indexOperand);
        boolean arabyNumbs = false;
        int a;
        int b;
        try{
            a = Integer.parseInt(arr[0]);
            arabyNumbs = true;
            b = Integer.parseInt(arr[2]);
            if(!(limit(a)&& limit(b))) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return e.toString();
                }
            }
        } catch(NumberFormatException e) {
            b = RymNumber.parseInt(arr[2]);
            if (arabyNumbs) {
                try {
                    throw new Exception();
                } catch (Exception ex) {
                    return ex.toString();
                }
            }
            a = RymNumber.parseInt(arr[0]);
            if (a == 0 || b == 0) {
                try {
                    throw new Exception();
                } catch (Exception ex) {
                    return ex.toString();
                }
            }
        }
        if(arabyNumbs) {
            switch (operand){
                case '+':
                    return String.valueOf(a+b);
                case '-':
                    return String.valueOf(a-b);
                case '/':
                    return String.valueOf(a/b);
                case '*':
                    return String.valueOf(a*b);
            }
        } else {
            int answer;
            switch (operand) {
                case '+':
                    return RymNumber.parseRym(a + b);
                case '-':
                    answer = a - b;
                    if (answer < 1) {
                        try {
                            throw new Exception();
                        } catch (Exception ex) {
                            return ex.toString();
                        }
                    }
                    return RymNumber.parseRym(answer);
                case '/':
                    answer = a / b;
                    if (answer < 1) {
                        try {
                            throw new Exception();
                        } catch (Exception ex) {
                            return ex.toString();
                        }
                    }
                    return RymNumber.parseRym(answer);
                case '*':
                    return RymNumber.parseRym(a * b);
            }
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            return e.toString();
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

package com.coding.numberconverter.service;

import com.coding.numberconverter.model.RomanNumeral;
import org.springframework.stereotype.Service;

@Service
public class NumberConverterSvc {

    private static final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] romanLiterals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    public RomanNumeral intToRoman(int number)
    {
        //creating array of place values
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String roman = thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number % 10];
        RomanNumeral converter = map(roman, number);

        return converter;
    }


    int NumValue(char rom){
        if (rom == 'I')
            return 1;
        if (rom == 'V')
            return 5;
        if (rom == 'X')
            return 10;
        if (rom == 'L')
            return 50;
        if (rom == 'C')
            return 100;
        if (rom == 'D')
            return 500;
        if (rom == 'M')
            return 1000;
        return -1;
    }
    public int romanToInt(String str) {
        int sum = 0;
        for (int i=0; i<str.length(); i++) {
            int s1 = NumValue(str.charAt(i));
            if (i+1 <str.length()) {
                int s2 = NumValue(str.charAt(i+1));
                if (s1 >= s2) {
                    sum = sum + s1;
                }
                else {
                    sum = sum - s1;
                }
            }
            else {
                sum = sum + s1;
            }
        }
        if(sum<0)
            throw new IllegalArgumentException("check parameter passed");
        return sum;
    }

    private RomanNumeral map(String result,int num){
        RomanNumeral converter = new RomanNumeral();
        converter.setDecimal(num);
        converter.setRomanNumeral(result);

        return converter;
    }
}


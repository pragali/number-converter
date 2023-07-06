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


    public  final RomanNumeral integerToRoman2(int number) {
        String roman ="";
        int i = getFloorIndex(number);
        if (number == values[i]) {
            roman+= romanLiterals[i];
        }

        roman=romanLiterals[i] + integerToRoman2(number - values[i]);
        RomanNumeral converter = map(roman, number);

        return converter;
    }

    private static int getFloorIndex(int number) {
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                return i;
            }
        }
        return -1;
    }

    private RomanNumeral map(String result,int num){
        RomanNumeral converter = new RomanNumeral();
        converter.setDecimal(num);
        converter.setRomanNumeral(result);

        return converter;
    }
}


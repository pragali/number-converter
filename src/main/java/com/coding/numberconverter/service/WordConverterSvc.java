package com.coding.numberconverter.service;

import org.springframework.stereotype.Service;

@Service
public class WordConverterSvc extends NumberConverterSvc{
    public  String convert_to_words(char[] num)
    {

        int len = num.length;
        String words ="";

        // Base cases
        if (len == 0) {
            throw new IllegalArgumentException("check parameter passed");
        }
        if (len > 4) {
            throw new IllegalArgumentException("lenght of 4 only supported,check parameter passed");
        }

        String[] single_digits = new String[] {
                "zero", "one", "two",   "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        String[] two_digits = new String[] {
                "",          "ten",      "eleven",  "twelve",
                "thirteen",  "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"
        };

        String[] tens_multiple = new String[] {
                "",      "",      "twenty",  "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        String[] tens_power = new String[] { "hundred", "thousand" };

        System.out.print(String.valueOf(num) + ": ");

        if (len == 1) {
            words+=single_digits[num[0] - '0'];
            return words;
        }

        int x = 0;
        while (x < num.length) { if (len >= 3) {
            if (num[x] - '0' != 0) {
                words+=single_digits[num[x] - '0'] + " ";
                words+=tens_power[len - 3] + " ";

            }
            --len;
        }

        else {

            if (num[x] - '0' == 1) {
                int sum
                        = num[x] - '0' + num[x + 1] - '0';
                words+=two_digits[sum];
                return words;
            }

            else if (num[x] - '0' == 2
                    && num[x + 1] - '0' == 0) {
                words+="twenty";
                return words;
            }

            else {
                int i = (num[x] - '0');
                if (i > 0)
                    words+=tens_multiple[i] + " ";
                else
                    words+="Invalid input";
                ++x;
                if (num[x] - '0' != 0)
                    words+=single_digits[num[x] - '0'];
            }
        }
            ++x;
        }
        return words;
    }

    /*public static void main(String[] args)
    {
        System.out.println(convert_to_words("1000".toCharArray()));
    }*/

}

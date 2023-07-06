package com.coding.numberconverter.service;

import org.springframework.stereotype.Service;

@Service
public class BinaryConverterSvc extends NumberConverterSvc{

    public static int toDecimal(String binary,int i)
    {
        // If we reached last character
        int n = binary.length();
        if (i == n-1)
            return binary.charAt(i) - '0';

        // Add current tern and recur for
        // remaining terms
        return ((binary.charAt(i) - '0') << (n-i-1)) +
                toDecimal(binary, i+1);
    }

    // Driver code
    public static void main(String []args)
    {
        String binary = "1010";
        int i=0;
        System.out.println(toDecimal(binary,i));

    }
}

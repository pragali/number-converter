package com.coding.numberconverter.service;

import org.springframework.stereotype.Service;

@Service
public class BinaryConverterSvc extends NumberConverterSvc{

    public int toDecimal(String binary,int i)
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

    public boolean isBinaryOrNot(int number)
    {
        boolean isBinary = true;

        int copyOfNumber = number;

        while (copyOfNumber != 0)
        {
            int temp = copyOfNumber%10;   //Gives last digit of the number

            if(temp > 1)
            {
                isBinary = false;
                break;
            }
            else
            {
                copyOfNumber = copyOfNumber/10;    //Removes last digit from the number
            }
        }

        if (isBinary)
        {
            System.out.println(number+" is a binary number");
        }
        else
        {
            System.out.println(number+" is not a binary number");
        }

        return isBinary;
    }



    // Driver code

}

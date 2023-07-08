package com.coding.numberconverter.controller;

import com.coding.numberconverter.model.BinaryNumeral;
import com.coding.numberconverter.model.RomanNumeral;
import com.coding.numberconverter.model.Words;
import com.coding.numberconverter.service.BinaryConverterSvc;
import com.coding.numberconverter.service.WordConverterSvc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.coding.numberconverter.service.NumberConverterSvc;

@RestController
@RequestMapping("convert")
public class NumberConverterController {

    private NumberConverterSvc numberConverterSvc;

    private BinaryConverterSvc binaryConverterSvc;

    private WordConverterSvc wordConverterSvc;

    public NumberConverterController(NumberConverterSvc numberConverterSvc,BinaryConverterSvc binaryConverterSvc,
                                     WordConverterSvc wordConverterSvc){
        this.numberConverterSvc = numberConverterSvc;
        this.binaryConverterSvc = binaryConverterSvc;
        this.wordConverterSvc = wordConverterSvc;
    }



    @RequestMapping(value = "/roman/{num}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RomanNumeral convert(@PathVariable int num){

        return  numberConverterSvc.intToRoman(num);
    }




    @RequestMapping(value = "/binary/{binary}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody BinaryNumeral convert(@PathVariable String binary){

       int decimal = binaryConverterSvc.toDecimal(binary,0);
       RomanNumeral romanNumeral = binaryConverterSvc.intToRoman(decimal);
       BinaryNumeral binaryNumeral = new BinaryNumeral(binary,decimal, romanNumeral.getRomanNumeral());
       return binaryNumeral;
    }

    @RequestMapping(value = "/words/{roman}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Words convertwords(@PathVariable String roman){

        int decimal = wordConverterSvc.romanToInt(roman);
        String text = wordConverterSvc.convert_to_words(String.valueOf(decimal).toCharArray());

        Words words = new Words(roman,decimal,text);

        return words;


    }


}

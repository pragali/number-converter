package com.coding.numberconverter.controller;

import com.coding.numberconverter.model.BinaryNumeral;
import com.coding.numberconverter.model.RomanNumeral;
import com.coding.numberconverter.service.BinaryConverterSvc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.coding.numberconverter.service.NumberConverterSvc;

@RestController
public class NumberConverterController {

    private NumberConverterSvc numberConverterSvc;

    private BinaryConverterSvc binaryConverterSvc;

    public NumberConverterController(NumberConverterSvc numberConverterSvc,BinaryConverterSvc binaryConverterSvc){
        this.numberConverterSvc = numberConverterSvc;
        this.binaryConverterSvc = binaryConverterSvc;
    }



    @RequestMapping(value = "/roman/{num}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RomanNumeral convert(@PathVariable int num){

        return  numberConverterSvc.intToRoman(num);
    }

    @RequestMapping(value = "/roman/v1/{num}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RomanNumeral convertV1(@PathVariable int num){

        return  numberConverterSvc.integerToRoman2(num);
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
}

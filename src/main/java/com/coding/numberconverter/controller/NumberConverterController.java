package com.coding.numberconverter.controller;

import com.coding.numberconverter.model.RomanNumeral;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.coding.numberconverter.service.NumberConverterSvc;

@RestController
public class NumberConverterController {

    private NumberConverterSvc numberConverterSvc;

    public NumberConverterController(NumberConverterSvc numberConverterSvc){
        this.numberConverterSvc = numberConverterSvc;
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
}

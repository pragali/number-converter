package com.coding.numberconverter.svc;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.coding.numberconverter.model.RomanNumeral;
import com.coding.numberconverter.service.NumberConverterSvc;
import org.junit.jupiter.api.Test;

public class NumberConverterSvcTest {
    NumberConverterSvc numberConverterSvc = new NumberConverterSvc();

    @Test
    void testRomanValue(){

        assertEquals(numberConverterSvc.intToRoman(10),new RomanNumeral(10,"X"));
    }

    @Test
    void testNumValue(){

        assertEquals(numberConverterSvc.romanToInt("X"),10);
    }
}

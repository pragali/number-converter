package com.coding.numberconverter.svc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.coding.numberconverter.service.WordConverterSvc;
import org.junit.jupiter.api.Test;

public class WordConverterSvcTest {
    WordConverterSvc wordConverterSvc= new WordConverterSvc();
    @Test
    void testConvertWords(){
        assertEquals(wordConverterSvc.convert_to_words("99".toCharArray()),"ninety nine");
    }

    @Test
    void testInvalidConvertWords(){
        assertEquals(wordConverterSvc.convert_to_words("00".toCharArray()),"Invalid input");
    }
}

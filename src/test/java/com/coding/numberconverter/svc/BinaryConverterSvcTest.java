package com.coding.numberconverter.svc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.coding.numberconverter.service.BinaryConverterSvc;
import org.junit.jupiter.api.Test;

public class BinaryConverterSvcTest {

    BinaryConverterSvc binaryConverterSvc = new BinaryConverterSvc();

    @Test
    void testisBinary(){
        assertEquals(binaryConverterSvc.isBinaryOrNot(1011),true);
        assertEquals(binaryConverterSvc.isBinaryOrNot(15),false);

    }

    @Test
    void testisDecimal(){
        assertEquals(binaryConverterSvc.toDecimal("1011",0),11);
    }
}

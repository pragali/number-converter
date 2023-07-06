package com.coding.numberconverter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BinaryNumeral {

    private String binary;

    private int decimal;

    private String romanNumeral;
}

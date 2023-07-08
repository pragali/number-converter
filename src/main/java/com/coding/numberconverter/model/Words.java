package com.coding.numberconverter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Words {

    private String romanNumeral;
    private int decimal;

    private String word;
}

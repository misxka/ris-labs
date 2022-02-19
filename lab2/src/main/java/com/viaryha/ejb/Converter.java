package com.viaryha.ejb;

import jakarta.ejb.Stateless;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Stateless
public class Converter implements ConverterLocal {
    private BigDecimal yenRate = new BigDecimal("83.0602");
    private BigDecimal euroRate = new BigDecimal("0.0093016");

    @Override
    public BigDecimal dollarToYen(BigDecimal dollars) {
        BigDecimal result = dollars.multiply(yenRate);
        return result.setScale(2, RoundingMode.UP);
    }

    @Override
    public BigDecimal yenToEuro(BigDecimal yen) {
        BigDecimal result = yen.multiply(euroRate);
        return result.setScale(2, RoundingMode.UP);
    }
}

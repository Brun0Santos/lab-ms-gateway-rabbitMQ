package io.github.bruno.cardreview.configs.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcUtil {
    public static BigDecimal incomeCalculation(BigDecimal income) {
        BigDecimal percentage = income.multiply(new BigDecimal("0.60")).setScale(2, RoundingMode.HALF_UP);
        return income.add(percentage);
    }
}

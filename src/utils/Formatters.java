package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatters {
    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String formatWage(BigDecimal wage) {
        DecimalFormatSymbols symbolFormatter = new DecimalFormatSymbols();

        symbolFormatter.setDecimalSeparator(',');
        symbolFormatter.setGroupingSeparator('.');

        var wageFormatter = new DecimalFormat("#,###.00", symbolFormatter);
        return wageFormatter.format(wage);
    }
}

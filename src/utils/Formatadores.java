package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatadores {
    public static String formatarData(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String formatarSalario(BigDecimal salario) {
        DecimalFormatSymbols formatadorSimbolos = new DecimalFormatSymbols();

        formatadorSimbolos.setDecimalSeparator(',');
        formatadorSimbolos.setGroupingSeparator('.');

        var formatadorSalario = new DecimalFormat("#,###.00", formatadorSimbolos);
        return formatadorSalario.format(salario);
    }
}

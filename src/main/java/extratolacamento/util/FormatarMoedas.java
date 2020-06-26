package extratolacamento.util;

import org.springframework.stereotype.Component;

import java.util.Locale; // Que permitirá a configuração da localidade.
import java.text.NumberFormat;// Permitirá a formatação do número adequadamente.

@Component
public class FormatarMoedas {
    private String brl;

    public FormatarMoedas() {
    }

    public String configurarMoeda(Double valor){

        Locale localBrasil = new Locale("pt", "BR");
        brl = NumberFormat.getCurrencyInstance(localBrasil).format(valor);

        return brl;

    }
}

package extratolacamento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DadosDomicilioBancario {
    private Integer numeroContaCorrente;
    private Integer codigoBanco;
    private Integer numeroAgencia;

    public DadosDomicilioBancario() {
    }

    public Integer getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public Integer getCodigoBanco() {
        return codigoBanco;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroContaCorrente(Integer numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }

    public void setCodigoBanco(Integer codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}

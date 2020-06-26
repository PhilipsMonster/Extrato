package extratolacamento.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Map;

@Entity
@Component
public class ExtratoView {
    private String dataLancamentoContaCorrenteCliente;
    private String nomeTipoOperacao;
    private Integer numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    private String dataEfetivaLancamento;
    private String nomeBanco;
    private String dadosDomicilioBancario;
    private Double valorLancamentos;

    public ExtratoView() {
    }

    public String getDataLancamentoContaCorrenteCliente() {
        return dataLancamentoContaCorrenteCliente;
    }

    public String getNomeTipoOperacao() {
        return nomeTipoOperacao;
    }

    public Integer getNumeroRemessaBanco() {
        return numeroRemessaBanco;
    }

    public String getNomeSituacaoRemessa() {
        return nomeSituacaoRemessa;
    }

    public String getDataEfetivaLancamento() {
        return dataEfetivaLancamento;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getDadosDomicilioBancario() {
        return dadosDomicilioBancario;
    }

    public Double getValorLancamentos() {
        return valorLancamentos;
    }

    public void setDataLancamentoContaCorrenteCliente(String dataLancamentoContaCorrenteCliente) {
        this.dataLancamentoContaCorrenteCliente = dataLancamentoContaCorrenteCliente;
    }

    public void setNomeTipoOperacao(String nomeTipoOperacao) {
        this.nomeTipoOperacao = nomeTipoOperacao;
    }

    public void setNumeroRemessaBanco(Integer numeroRemessaBanco) {
        this.numeroRemessaBanco = numeroRemessaBanco;
    }

    public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
        this.nomeSituacaoRemessa = nomeSituacaoRemessa;
    }

    public void setDataEfetivaLancamento(String dataEfetivaLancamento) {
        this.dataEfetivaLancamento = dataEfetivaLancamento;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public void setDadosDomicilioBancario(String dadosDomicilioBancario) {
        this.dadosDomicilioBancario = dadosDomicilioBancario;
    }

    public void setValorLancamentos(Double valorLancamentos) {
        this.valorLancamentos = valorLancamentos;
    }
}

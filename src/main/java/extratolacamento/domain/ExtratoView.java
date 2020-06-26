package extratolacamento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtratoView {
    private String dataLancamentoContaCorrenteCliente;
    private String nomeTipoOperacao;
    private Long numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    private String dataEfetivaLancamento;
    private String dadosDomicilioBancario;
    private String valorLancamentos;

    public ExtratoView() {
    }

    public String getDataLancamentoContaCorrenteCliente() {
        return dataLancamentoContaCorrenteCliente;
    }

    public String getNomeTipoOperacao() {
        return nomeTipoOperacao;
    }

    public Long getNumeroRemessaBanco() {
        return numeroRemessaBanco;
    }

    public String getNomeSituacaoRemessa() {
        return nomeSituacaoRemessa;
    }

    public String getDataEfetivaLancamento() {
        return dataEfetivaLancamento;
    }

    public String getDadosDomicilioBancario() {
        return dadosDomicilioBancario;
    }

    public String getValorLancamentos() {
        return valorLancamentos;
    }

    public void setDataLancamentoContaCorrenteCliente(String dataLancamentoContaCorrenteCliente) {
        this.dataLancamentoContaCorrenteCliente = dataLancamentoContaCorrenteCliente;
    }

    public void setNomeTipoOperacao(String nomeTipoOperacao) {
        this.nomeTipoOperacao = nomeTipoOperacao;
    }

    public void setNumeroRemessaBanco(Long numeroRemessaBanco) {
        this.numeroRemessaBanco = numeroRemessaBanco;
    }

    public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
        this.nomeSituacaoRemessa = nomeSituacaoRemessa;
    }

    public void setDataEfetivaLancamento(String dataEfetivaLancamento) {
        this.dataEfetivaLancamento = dataEfetivaLancamento;
    }

    public void setDadosDomicilioBancario(String dadosDomicilioBancario) {
        this.dadosDomicilioBancario = dadosDomicilioBancario;
    }

    public void setValorLancamentos(String valorLancamentos) {
        this.valorLancamentos = valorLancamentos;
    }
}

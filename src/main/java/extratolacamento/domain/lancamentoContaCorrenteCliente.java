package extratolacamento.domain;

import java.util.Map;

public class lancamentoContaCorrenteCliente {
    private Long numeroRemessaBanco;
    private String[] dadosAnaliticoLancamentoFinanceiroCliente;
    private String nomeSituacaoRemessa;
    private Map<String, Integer> dadosDomicilioBancario; // map
    private String nomeTipoOperacao;

    public lancamentoContaCorrenteCliente() {
    }

    public Long getNumeroRemessaBanco() {
        return numeroRemessaBanco;
    }

    public String[] getDadosAnaliticoLancamentoFinanceiroCliente() {
        return dadosAnaliticoLancamentoFinanceiroCliente;
    }

    public String getNomeSituacaoRemessa() {
        return nomeSituacaoRemessa;
    }

    public Map<String, Integer> getDadosDomicilioBancario() {
        return dadosDomicilioBancario;
    }

    public String getNomeTipoOperacao() {
        return nomeTipoOperacao;
    }

    public void setNumeroRemessaBanco(Long numeroRemessaBanco) {
        this.numeroRemessaBanco = numeroRemessaBanco;
    }

    public void setDadosAnaliticoLancamentoFinanceiroCliente(String[] dadosAnaliticoLancamentoFinanceiroCliente) {
        this.dadosAnaliticoLancamentoFinanceiroCliente = dadosAnaliticoLancamentoFinanceiroCliente;
    }

    public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
        this.nomeSituacaoRemessa = nomeSituacaoRemessa;
    }

    public void setDadosDomicilioBancario(Map<String, Integer> dadosDomicilioBancario) {
        this.dadosDomicilioBancario = dadosDomicilioBancario;
    }

    public void setNomeTipoOperacao(String nomeTipoOperacao) {
        this.nomeTipoOperacao = nomeTipoOperacao;
    }
}

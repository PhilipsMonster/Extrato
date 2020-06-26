package extratolacamento.domain;

public class LancamentoContaCorrenteCliente {
    private Long numeroRemessaBanco;
    private String[] dadosAnaliticoLancamentoFinanceiroCliente;
    private String nomeSituacaoRemessa;
    private DadosDomicilioBancario dadosDomicilioBancario;
    private String nomeTipoOperacao;

    public LancamentoContaCorrenteCliente() {
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

    public DadosDomicilioBancario getDadosDomicilioBancario() {
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

    public void setDadosDomicilioBancario(DadosDomicilioBancario dadosDomicilioBancario) {
        this.dadosDomicilioBancario = dadosDomicilioBancario;
    }

    public void setNomeTipoOperacao(String nomeTipoOperacao) {
        this.nomeTipoOperacao = nomeTipoOperacao;
    }
}

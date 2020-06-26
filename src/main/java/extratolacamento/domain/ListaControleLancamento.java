package extratolacamento.domain;

public class ListaControleLancamento {
    private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;
    private String dataEfetivaLancamento;
    private String dataLancamentoContaCorrenteCliente;
    private String numeroEvento;
    private String descricaoGrupoPagamento;
    private String codigoIdentificadorUnico;
    private String nomeBanco;
    private String quantidadeLancamentoRemessa;
    private String numeroRaizCNPJ;
    private String numeroSufixoCNPJ;
    private String valorLancamentoRemessa;
    private String dateLancamentoContaCorrenteCliente;
    private String dateEfetivaLancamento;

    public ListaControleLancamento() {
    }

    public LancamentoContaCorrenteCliente getLancamentoContaCorrenteCliente() {
        return lancamentoContaCorrenteCliente;
    }

    public String getDataEfetivaLancamento() {
        return dataEfetivaLancamento;
    }

    public String getDataLancamentoContaCorrenteCliente() {
        return dataLancamentoContaCorrenteCliente;
    }

    public String getNumeroEvento() {
        return numeroEvento;
    }

    public String getDescricaoGrupoPagamento() {
        return descricaoGrupoPagamento;
    }

    public String getCodigoIdentificadorUnico() {
        return codigoIdentificadorUnico;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getQuantidadeLancamentoRemessa() {
        return quantidadeLancamentoRemessa;
    }

    public String getNumeroRaizCNPJ() {
        return numeroRaizCNPJ;
    }

    public String getNumeroSufixoCNPJ() {
        return numeroSufixoCNPJ;
    }

    public String getValorLancamentoRemessa() {
        return valorLancamentoRemessa;
    }

    public String getDateLancamentoContaCorrenteCliente() {
        return dateLancamentoContaCorrenteCliente;
    }

    public String getDateEfetivaLancamento() {
        return dateEfetivaLancamento;
    }

    public void setLancamentoContaCorrenteCliente(LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente) {
        this.lancamentoContaCorrenteCliente = lancamentoContaCorrenteCliente;
    }

    public void setDataEfetivaLancamento(String dataEfetivaLancamento) {
        this.dataEfetivaLancamento = dataEfetivaLancamento;
    }

    public void setDataLancamentoContaCorrenteCliente(String dataLancamentoContaCorrenteCliente) {
        this.dataLancamentoContaCorrenteCliente = dataLancamentoContaCorrenteCliente;
    }

    public void setNumeroEvento(String numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    public void setDescricaoGrupoPagamento(String descricaoGrupoPagamento) {
        this.descricaoGrupoPagamento = descricaoGrupoPagamento;
    }

    public void setCodigoIdentificadorUnico(String codigoIdentificadorUnico) {
        this.codigoIdentificadorUnico = codigoIdentificadorUnico;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public void setQuantidadeLancamentoRemessa(String quantidadeLancamentoRemessa) {
        this.quantidadeLancamentoRemessa = quantidadeLancamentoRemessa;
    }

    public void setNumeroRaizCNPJ(String numeroRaizCNPJ) {
        this.numeroRaizCNPJ = numeroRaizCNPJ;
    }

    public void setNumeroSufixoCNPJ(String numeroSufixoCNPJ) {
        this.numeroSufixoCNPJ = numeroSufixoCNPJ;
    }

    public void setValorLancamentoRemessa(String valorLancamentoRemessa) {
        this.valorLancamentoRemessa = valorLancamentoRemessa;
    }

    public void setDateLancamentoContaCorrenteCliente(String dateLancamentoContaCorrenteCliente) {
        this.dateLancamentoContaCorrenteCliente = dateLancamentoContaCorrenteCliente;
    }

    public void setDateEfetivaLancamento(String dateEfetivaLancamento) {
        this.dateEfetivaLancamento = dateEfetivaLancamento;
    }
}

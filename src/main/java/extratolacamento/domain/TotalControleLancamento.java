package extratolacamento.domain;

public class TotalControleLancamento {
    private Integer quantidadeLancamentos;
    private Integer quantidadeRemessas;
    private Double valorLancamentos;

    public TotalControleLancamento() {
    }

    public Integer getQuantidadeLancamentos() {
        return quantidadeLancamentos;
    }

    public Integer getQuantidadeRemessas() {
        return quantidadeRemessas;
    }

    public Double getValorLancamentos() {
        return valorLancamentos;
    }

    public void setQuantidadeLancamentos(Integer quantidadeLancamentos) {
        this.quantidadeLancamentos = quantidadeLancamentos;
    }

    public void setQuantidadeRemessas(Integer quantidadeRemessas) {
        this.quantidadeRemessas = quantidadeRemessas;
    }

    public void setValorLancamentos(Double valorLancamentos) {
        this.valorLancamentos = valorLancamentos;
    }
}

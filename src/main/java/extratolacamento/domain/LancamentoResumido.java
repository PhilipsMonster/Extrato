package extratolacamento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LancamentoResumido {
    private String dataLancamento;
    private String descricao;
    private Long numero;
    private String situacao;
    private String dataConfirmacao;
    private String dadosBancarios;
    private String valorFinal;

    public LancamentoResumido() {
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getNumero() {
        return numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getDataConfirmacao() {
        return dataConfirmacao;
    }

    public String getDadosBancarios() {
        return dadosBancarios;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setDataConfirmacao(String dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }

    public void setDadosBancarios(String dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }
}

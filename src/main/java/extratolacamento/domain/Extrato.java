package extratolacamento.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Convert;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Component
public class Extrato {

    private Map<String, Double> totalControleLancamento; // map
    private List<listaControleLancamento> listaControleLancamento;
    private int indice;
    private int tamanhoPagina;
    private int totalElements;
    /*private String[] position;              // array
    private List<String> skills;            // list*/

    public Extrato() {
    }

    public Map<String, Double> getTotalControleLancamento() {
        return totalControleLancamento;
    }

    public List<extratolacamento.domain.listaControleLancamento> getListaControleLancamento() {
        return listaControleLancamento;
    }

    public int getIndice() {
        return indice;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalControleLancamento(Map<String, Double> totalControleLancamento) {
        this.totalControleLancamento = totalControleLancamento;
    }

    public void setListaControleLancamento(List<extratolacamento.domain.listaControleLancamento> listaControleLancamento) {
        this.listaControleLancamento = listaControleLancamento;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}

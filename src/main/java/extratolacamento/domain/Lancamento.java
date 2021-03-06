package extratolacamento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lancamento {

    private TotalControleLancamento totalControleLancamento;
    private List<ListaControleLancamento> listaControleLancamento;
    private int indice;
    private int tamanhoPagina;
    private int totalElements;
    /*private String[] position;              // array
    private List<String> skills;            // list*/

    public Lancamento() {
    }

    public TotalControleLancamento getTotalControleLancamento() {
        return totalControleLancamento;
    }

    public List<ListaControleLancamento> getListaControleLancamento() {
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

    public void setTotalControleLancamento(TotalControleLancamento totalControleLancamento) {
        this.totalControleLancamento = totalControleLancamento;
    }

    public void setListaControleLancamento(List<ListaControleLancamento> listaControleLancamento) {
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

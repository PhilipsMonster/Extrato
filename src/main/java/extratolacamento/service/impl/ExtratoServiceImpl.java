package extratolacamento.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import extratolacamento.domain.Lancamento;
import extratolacamento.domain.LancamentoResumido;
import extratolacamento.json.ReadJSON;
import extratolacamento.service.ExtratoService;
import extratolacamento.util.FormatarMoedas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtratoServiceImpl implements ExtratoService {

    @Autowired
    private Lancamento lancamento;

    @Autowired
    private FormatarMoedas format;

    @Autowired
    private ReadJSON readJson;

    @Override
    public List<LancamentoResumido> getLancamentos() throws IOException, ParseException {

        LancamentoResumido lancResum;
        List<LancamentoResumido> lancsRes = new ArrayList<LancamentoResumido>();
        Lancamento lanc = readJson.JsonToObject();

        try
        {
            for (int i=0; i<lanc.getListaControleLancamento().size(); i++){

                lancResum = new LancamentoResumido();
                String dadosBancarios;
                String nomeBanco;
                String numeroAgencia;
                String numeroContaCorrente;
                String tipoOperacao;
                String valorLancamento;

                //Dados do lançamento na conta
                if (lanc.getListaControleLancamento().get(i).getDataLancamentoContaCorrenteCliente() != null){
                    lancResum.setDataLancamento(lanc.getListaControleLancamento().get(i).getDataLancamentoContaCorrenteCliente());
                }

                if(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeTipoOperacao() != null){
                    tipoOperacao = lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeTipoOperacao();
                    lancResum.setDescricao(tipoOperacao.substring(0,1).toUpperCase() + tipoOperacao.substring(1));
                }

                if(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco() != null){
                    lancResum.setNumero(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
                }

                if(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa() != null){
                    lancResum.setSituacao(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
                }

                if(lanc.getListaControleLancamento().get(i).getDataEfetivaLancamento() != null){
                    lancResum.setDataConfirmacao(lanc.getListaControleLancamento().get(i).getDataEfetivaLancamento());
                }

                //Dados do domicílio bancário
                if(lanc.getListaControleLancamento().get(i).getNomeBanco() != null
                        || lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia() != null
                        ||lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente() != null){
                    nomeBanco = lanc.getListaControleLancamento().get(i).getNomeBanco();
                    numeroAgencia = String.valueOf(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
                    numeroContaCorrente = String.valueOf(lanc.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente());
                    dadosBancarios = nomeBanco.trim() +"Ag "+ numeroAgencia + " CC " + numeroContaCorrente;
                    lancResum.setDadosBancarios(dadosBancarios);
                }

                //Valor de lançamento (com o tratamento de moeda)
                if(lanc.getTotalControleLancamento().getValorLancamentos() != null){
                    valorLancamento = format.configMoeda(lanc.getTotalControleLancamento().getValorLancamentos());
                    lancResum.setValorFinal(valorLancamento);
                }

                lancsRes.add(lancResum);

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return lancsRes;
    }
}

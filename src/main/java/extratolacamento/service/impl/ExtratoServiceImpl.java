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
    public List<LancamentoResumido> getLancamento() throws IOException, ParseException {

        LancamentoResumido extView;
        List<LancamentoResumido> extratoVL = new ArrayList<LancamentoResumido>();
        Lancamento ext = readJson.JsonToObject();

        try
        {
            for (int i=0; i<ext.getListaControleLancamento().size(); i++){

                extView = new LancamentoResumido();
                String dadosBancarios;
                String nomeBanco;
                String numeroAgencia;
                String numeroContaCorrente;
                String tipoOperacao;
                String valorLancamento;

                //Dados do lançamento na conta
                if (ext.getListaControleLancamento().get(i).getDataLancamentoContaCorrenteCliente() != null){
                    extView.setDataLancamento(ext.getListaControleLancamento().get(i).getDataLancamentoContaCorrenteCliente());
                }

                if(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeTipoOperacao() != null){
                    tipoOperacao = ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeTipoOperacao();
                    extView.setDescricao(tipoOperacao.substring(0,1).toUpperCase() + tipoOperacao.substring(1));
                }

                if(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco() != null){
                    extView.setNumero(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
                }

                if(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa() != null){
                    extView.setSituacao(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
                }

                if(ext.getListaControleLancamento().get(i).getDataEfetivaLancamento() != null){
                    extView.setDataConfirmacao(ext.getListaControleLancamento().get(i).getDataEfetivaLancamento());
                }

                //Dados do domicílio bancário
                if(ext.getListaControleLancamento().get(i).getNomeBanco() != null
                        || ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia() != null
                        ||ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente() != null){
                    nomeBanco = ext.getListaControleLancamento().get(i).getNomeBanco();
                    numeroAgencia = String.valueOf(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
                    numeroContaCorrente = String.valueOf(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente());
                    dadosBancarios = nomeBanco.trim() +"Ag "+ numeroAgencia + " CC " + numeroContaCorrente;
                    extView.setDadosBancarios(dadosBancarios);
                }

                //Valor de lançamento (com o tratamento de moeda)
                if(ext.getTotalControleLancamento().getValorLancamentos() != null){
                    valorLancamento = format.configurarMoeda(ext.getTotalControleLancamento().getValorLancamentos());
                    extView.setValorFinal(valorLancamento);
                }

                extratoVL.add(extView);

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return extratoVL;
    }
}

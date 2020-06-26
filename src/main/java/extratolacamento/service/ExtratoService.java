package extratolacamento.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import extratolacamento.domain.Extrato;
import extratolacamento.domain.ExtratoView;
import extratolacamento.json.ReadJSON;
import extratolacamento.util.FormatarMoedas;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtratoService {

    @Autowired
    private Extrato extrato;

    @Autowired
    private FormatarMoedas format;

    @Autowired
    private ReadJSON readJson;

    public List<ExtratoView> getExtrato() throws IOException, ParseException {

        ExtratoView extView;
        List<ExtratoView> extratoVL = new ArrayList<ExtratoView>();
        Extrato ext = readJson.JsonToObject();

        try
        {
            for (int i=0; i<ext.getListaControleLancamento().size(); i++){

                extView = new ExtratoView();
                String dadosBancarios;
                String nomeBanco;
                String numeroAgencia;
                String numeroContaCorrente;
                String tipoOperacao;
                String valorLancamento;

                extView.setDataLancamentoContaCorrenteCliente(ext.getListaControleLancamento().get(i).getDataLancamentoContaCorrenteCliente());

                tipoOperacao = ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeTipoOperacao();
                extView.setNomeTipoOperacao(tipoOperacao.substring(0,1).toUpperCase() + tipoOperacao.substring(1));

                extView.setNumeroRemessaBanco(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
                extView.setNomeSituacaoRemessa(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
                extView.setDataEfetivaLancamento(ext.getListaControleLancamento().get(i).getDataEfetivaLancamento());

                //Dados bancários
                nomeBanco = ext.getListaControleLancamento().get(i).getNomeBanco();
                numeroAgencia = String.valueOf(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
                numeroContaCorrente = String.valueOf(ext.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente());
                dadosBancarios = nomeBanco.trim() +"Ag "+ numeroAgencia + " CC " + numeroContaCorrente;
                extView.setDadosDomicilioBancario(dadosBancarios);

                //Valor de lançamento com tratamento de moeda
                valorLancamento = format.configurarMoeda(ext.getTotalControleLancamento().getValorLancamentos());
                extView.setValorLancamentos(valorLancamento);

                extratoVL.add(extView);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return extratoVL;
    }
}

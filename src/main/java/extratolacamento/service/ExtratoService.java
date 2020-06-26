package extratolacamento.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import extratolacamento.domain.Extrato;
import extratolacamento.domain.ExtratoView;
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

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtratoService {

    @Autowired
    private Extrato extrato;
    @Autowired
    //private ExtratoView extView;

    public List<ExtratoView> getExtrato() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        List<ExtratoView> extratoVL = new ArrayList<ExtratoView>();
        ExtratoView extView;

        try (FileReader reader = new FileReader("/home/pi/Documents/Source/Extrato/Extrato/src/main/resources/extrato.json"))
        {
            Object obj = jsonparser.parse(reader);
            JSONObject jo = (JSONObject)obj;
            Gson gson = new Gson();
            byte[] jsonData = jo.toString().getBytes();

            ObjectMapper mapper = new ObjectMapper();
            extrato = mapper.readValue(jsonData, Extrato.class);

            //System.out.println(extView.getValorLancamentos());

            for (int i=0; i<extrato.getListaControleLancamento().size(); i++){

                extView = new ExtratoView();

                extView.setDataLancamentoContaCorrenteCliente(extrato.getListaControleLancamento().get(i).getDataLancamentoContaCorrenteCliente());
                extView.setNomeTipoOperacao(extrato.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
                extView.setNumeroRemessaBanco(extrato.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
                extView.setNomeSituacaoRemessa(extrato.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
                extView.setDataEfetivaLancamento(extrato.getListaControleLancamento().get(i).getDateEfetivaLancamento());
                extView.setNomeBanco(extrato.getListaControleLancamento().get(i).getNomeBanco());
                extView.setNumeroAgencia(extrato.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
                extView.setNumeroContaCorrente(extrato.getListaControleLancamento().get(i).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente());
                extView.setValorLancamentos(extrato.getTotalControleLancamento().getValorLancamentos());

                extratoVL.add(extView);
            }

            //extrato = gson.fromJson(reader, Extrato.class);
            // print staff object


            /*JSONArray array = (JSONArray)jo.get("listaControleLancamento");

            String arr[] = new String[array.size()];*/

            /*for (int i=0;i<array.size();i++)
            {
                JSONObject lancs = (JSONObject) array.get(i);
                Extrato extrato = gson.toJson(lancs,Extrato.class);

                arr[i] = (String)lancs.get("dataEfetivaLancamento");
                extratos.add(arr[i]);
            }*/


        }catch (Exception e) {
            e.printStackTrace();
        }

        return extratoVL;
    }
}

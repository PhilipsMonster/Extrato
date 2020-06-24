package extratolacamento.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import extratolacamento.domain.Extrato;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class ExtratoService {


    public List<Extrato> getExtrato() throws IOException, ParseException {

        //JSONParser jsonparser = new JSONParser();
        ArrayList<Extrato> extratos = new ArrayList<>();

        try {

            //String fileName = "*/extrato";
            //String filePath = fileName;
            //Object obj = jsonparser.parse(new FileReader(filePath));
            //JSONObject jsonObject = (JSONObject)obj;

            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/extrato.json");
            Object obj = mapper.readValue(is, ExtratoService.class);
            JSONObject jsonObject = (JSONObject)obj;

            String quantidadeLancamentos = (String)jsonObject.get("firstName");
            String quantidadeRemessas = (String)jsonObject.get("lastName");

            extratos.add(new Extrato(1L, quantidadeLancamentos));
            extratos.add(new Extrato(2L, quantidadeRemessas));

        }catch (Exception e) {
            e.printStackTrace();
        }

        return extratos;
    }
}

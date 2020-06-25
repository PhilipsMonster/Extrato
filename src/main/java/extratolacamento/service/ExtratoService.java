package extratolacamento.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import extratolacamento.domain.Extrato;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
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

    //@Autowired
    //private Extrato extrato;

    public Extrato getExtrato() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        Extrato extrato = new Extrato();

        try (FileReader reader = new FileReader("/home/pi/Documents/Source/Extrato/Extrato/src/main/resources/extrato.json"))
        {
            Object obj = jsonparser.parse(reader);
            JSONObject jo = (JSONObject)obj;
            Gson gson = new Gson();
            byte[] jsonData = jo.toString().getBytes();

            ObjectMapper mapper = new ObjectMapper();
            extrato = mapper.readValue(jsonData, Extrato.class);

            System.out.println(reader);
            System.out.println(extrato);

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

        return extrato;
    }
}

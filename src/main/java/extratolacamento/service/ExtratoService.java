package extratolacamento.service;

import com.google.gson.Gson;
import extratolacamento.domain.Extrato;
import net.minidev.json.writer.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class ExtratoService {


    public List<Extrato> getExtrato() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        ArrayList<Extrato> extratos = new ArrayList<>();

        try {

            //String absolutePath = new File("src/main/resources").getAbsolutePath();
            //String fileName = "/extrato.json";
            //String filePath = absolutePath + fileName;

            //Object obj = jsonparser.parse(new FileReader(filePath));
            //JSONObject jsonObject = (JSONObject)obj;
            //String quantidadeLancamentos = (String)jsonObject.get("firstName");
            //String quantidadeRemessas = (String)jsonObject.get("lastName");

            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(Randomizer.class
                    .getResourceAsStream("data/json/FatesSkills.json"), "UTF-8")));
            skills = gson.fromJson(reader, skillType);
            reader.close();


            extratos.add(new Extrato(1L, quantidadeLancamentos));
            extratos.add(new Extrato(2L, quantidadeRemessas));

        }catch (Exception e) {
            e.printStackTrace();
        }

        return extratos;
    }
}

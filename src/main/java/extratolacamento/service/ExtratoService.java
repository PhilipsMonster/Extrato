package extratolacamento.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import extratolacamento.domain.Extrato;
import org.json.simple.JSONArray;
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

    public List<Extrato> getExtrato() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        ArrayList<Extrato> extratos = new ArrayList<>();

        try (FileReader reader = new FileReader("C:/Source/Extrato/src/main/resources/extrato.json"))
        {
            Object obj = jsonparser.parse(reader);
            JSONObject jo = (JSONObject)obj;

            // getting firstName and lastName
            String firstName = (String) jo.get("firstName");
            String lastName = (String) jo.get("lastName");

            JSONArray array = (JSONArray)jo.get("address");
            String street = "";
            String city = "";
            String state = "";

            for (int i=0;i<array.size();i++)
            {
                JSONObject address = (JSONObject) array.get(i);
                street = (String)address.get("street");
                city = (String)address.get("city");
                state = (String)address.get("state");
            }

            extratos.add(new Extrato(firstName, lastName, street, city, state));


        }catch (Exception e) {
            e.printStackTrace();
        }

        return extratos;
    }
}

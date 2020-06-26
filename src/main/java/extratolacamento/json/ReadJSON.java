package extratolacamento.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import extratolacamento.domain.Extrato;
import extratolacamento.domain.ExtratoView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReadJSON {

    @Autowired
    private Extrato extrato;

    @Value("${file.reader.json-path}")
    private String jsonPath;

    public ReadJSON() {
    }

    public Extrato JsonToObject()
{

    JSONParser jsonparser = new JSONParser();

    try (FileReader reader = new FileReader(jsonPath)) {
        Object obj = jsonparser.parse(reader);
        JSONObject jo = (JSONObject) obj;
        Gson gson = new Gson();
        byte[] jsonData = jo.toString().getBytes();

        ObjectMapper mapper = new ObjectMapper();
        extrato = mapper.readValue(jsonData, Extrato.class);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return  extrato;
}
}

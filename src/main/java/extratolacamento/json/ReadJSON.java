package extratolacamento.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import extratolacamento.domain.Lancamento;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ReadJSON {

    @Autowired
    private Lancamento lancamento;

    @Value("${file.reader.json-path}")
    private String jsonPath;

    public ReadJSON() {
    }

    public Lancamento JsonToObject()
    {

        JSONParser jsonparser = new JSONParser();

        try (FileReader reader = new FileReader(jsonPath)) {
            Object obj = jsonparser.parse(reader);
            JSONObject jo = (JSONObject) obj;
            Gson gson = new Gson();
            byte[] jsonData = jo.toString().getBytes();

            ObjectMapper mapper = new ObjectMapper();
            lancamento = mapper.readValue(jsonData, Lancamento.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lancamento;
    }
}

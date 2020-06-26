package extratolacamento.service;

import extratolacamento.domain.ExtratoView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface ExtratoService {

    public List<ExtratoView> getExtrato() throws IOException, ParseException;
}

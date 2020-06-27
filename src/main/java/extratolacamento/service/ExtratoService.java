package extratolacamento.service;

import extratolacamento.domain.LancamentoResumido;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface ExtratoService {

    public List<LancamentoResumido> getLancamento() throws IOException, ParseException;
}

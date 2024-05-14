package repository;

import java.util.List;
import model.Relatorio;

public interface RelatorioRepository {

    public Relatorio saveRelatorio(Relatorio relatorio);
    
    public boolean  deleteRelatorio(String titulo, String data);

    public Relatorio readRelatorioByTitle(String titulo);

    public List<Relatorio> readRelatorioByParametro(String tipoParametro,String Parametro);

    public void readRelatorioParametros(Relatorio relatorio);

}

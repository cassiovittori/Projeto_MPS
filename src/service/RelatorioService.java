package service;

//import java.util.ArrayList;
import java.util.List;
import model.Relatorio;
import repository.RelatorioRepository;
import repository.RelatorioRepositoryImp;
//import utils.Constantes;

public class RelatorioService {

    private static RelatorioRepository repository;
   // private String arquivoUsuarios;
    //private String urlBanco;
    private static RelatorioService instance;

    private RelatorioService(){
        this.repository = RelatorioRepositoryImp.getInstance();
     //   this.arquivoUsuarios = Constantes.ARQUIVO_USERS;
       // this.urlBanco = Constantes.URL_BANCO;
    }

    public static RelatorioService getInstance(){
        if (instance == null) {
            instance = new RelatorioService();
        }
        return instance;
    }

    public static Relatorio criarRelatorio(Relatorio relatorio){

        return repository.saveRelatorio(relatorio);

    }

    public boolean  deleteRelatorio(Relatorio relatorio){

       return repository.deleteRelatorio(relatorio.getTitulo(), relatorio.getData());

    }

    public Relatorio readRelatorio(String titulo){

        return repository.readRelatorioByTitle(titulo);
    }

    public List<Relatorio> readRelatorioByParame(String tipoParametro, String Parametro){

       return  repository.readRelatorioByParametro(tipoParametro, Parametro);

    }

    
}

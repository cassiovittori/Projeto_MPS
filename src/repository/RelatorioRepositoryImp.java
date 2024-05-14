package repository;

import java.util.ArrayList;
import java.util.List;
import model.Relatorio;

public class RelatorioRepositoryImp implements RelatorioRepository {

    private static RelatorioRepositoryImp instance;

    public static RelatorioRepositoryImp getInstance(){
        if (instance == null) {
            instance = new RelatorioRepositoryImp();
        }
        return instance;
    }

    @Override
    public Relatorio saveRelatorio(Relatorio relatorio) {
       
        System.out.println("Salvando relatorio...\n");
        System.out.println(relatorio.toString());
        return null;

    }

    @Override
    public boolean deleteRelatorio(String titulo, String data) {
        
        System.out.println("Buscando relatorio...");
        System.out.println("Deletando o relatorio " + titulo + "da data" + data);
        System.out.println("Relatorio deletado com SUCESSO!");   
        
        return true;
    }

    @Override
    public Relatorio readRelatorioByTitle(String titulo) {
        System.out.println("Buscando relatorio de titulo..."+titulo);
        System.out.println("Encontrado o relatorio " + titulo);
        System.out.println("Relatorio deletado com SUCESSO!"); 
        return null;

    }

    @Override
    public List<Relatorio> readRelatorioByParametro(String tipoParametro,String Parametro){
       
        System.out.println("Buscando os relatorios que tem o parametro " + tipoParametro +"com o valor" + Parametro);
        System.out.println("Relatorios encontrados!");
        System.out.println("Lista:");
        System.out.println("Relatorio 1 que possui o parametro " + tipoParametro + "com o valor" + Parametro);
        System.out.println("Relatorio 2 que possui o parametro " + tipoParametro + "com o valor" + Parametro);
        System.out.println("Relatorio 3 que possui o parametro " + tipoParametro + "com o valor" + Parametro);


        List<Relatorio> relatorios = new ArrayList<>();
        
        return  relatorios;

    }

    @Override
    public void readRelatorioParametros(Relatorio relatorio){

        System.out.println("Titulo: " +relatorio.getTitulo());
        System.out.println("Descricao:" + relatorio.getDescricao());
        System.out.println("Data:" + relatorio.getData());
        System.out.println("Autor:"+relatorio.getAutor());

    }


}

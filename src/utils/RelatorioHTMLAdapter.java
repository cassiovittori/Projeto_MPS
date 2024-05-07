package utils;


import factory.FabricaRelatorio;
import model.Relatorio;


/* 

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
*/

public class RelatorioHTMLAdapter {


    ////////problema com a biblioteca jsoup////
    /* 
    public static String extrairTexto(Relatorio relatorio) {
        // Parse do HTML para um documento Jsoup
        Document documento = Jsoup.parse(relatorio);

        // Seleciona todos os elementos de texto do documento
        Elements elemen = doc.body().select("*:not(:has(*))");

        // Usa um StringBuilder para construir a string final
        StringBuilder texto = new StringBuilder();
        for (Element elemento : elemen) {
            texto.append(elemento.text()).append("\n");
        }

        // Retorna a string resultante
        return texto.toString();
    }
    */
    public static Relatorio conversor(Relatorio relatorio){
        String head = extrairTexto(relatorio.getCabecalho());
        String body = extrairTexto(relatorio.getCorpo());
        String foot = extrairTexto(relatorio.getRodape());
        Relatorio relatorioAdaptado = FabricaRelatorio.criaRelatorio(head, body, foot, relatorio.getAutor(), relatorio.getDataCriacao());

        return relatorioAdaptado;

    }

    public static String extrairTexto(String html) {
        String textoPuro = html.replaceAll("\\<.*?\\>", "");
        textoPuro = textoPuro.replaceAll("\\s+", " ").trim();

        return textoPuro;
    }


}

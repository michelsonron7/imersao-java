package application;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		
		 // fazer uma conexão HTTP e buscar os top 250 filmes
		
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

		//String url = "https://apod.nasa.gov/apod/image/2304/GalCenRadioArc_MeerKat_1080.jpg";
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoNASA();

		

		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		 
		
		// exibir e manipular os dados 
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		var geradora = new GeradoraDeFigurinhas(); 
		
		for (int i = 0; i < 3; i++) {
			
			Conteudo conteudo = conteudos.get(i);
									
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + "png";
			
			
			geradora.criar(inputStream, nomeArquivo);
			
			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
		
	}

}

package alura;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Alura {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		////key Api
		String url = "https://api.mocki.io/v2/549a5d8b";
		
		/////// Busca cliente htpp
		var	htpp = new ClienteHttp();
		String json = htpp.buscandoDados(url);
		

		
		//exibir e manipular os dados
		
		ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();
		List<Conteudo> conteudos = extrator.extraConteudos(json);
		
		for (int i = 0; i< 3; i++) {
			
			Conteudo conteudo = conteudos.get(i);
			
			 InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			 String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png"; ///"saida" e a pasta
	            GeradorDeFigurinhaWhatsapp.cria(inputStream, nomeArquivo);
	            
	            System.out.println(conteudo.getTitulo());
	            System.out.println(conteudo.getUrlImagem());
			
		}
					
			
		}
		
		
	}



package alura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB {
	
public List<Conteudo> extraConteudos (String json) {
		
		// Pegar dados ( titulo, poster....)
				var parser = new Jsonparser();
				List<Map<String, String>> ListaDeAtributos = parser.parse(json);
				
				List<Conteudo> conteudos = new ArrayList<>();
				
				//popular a lista de conteudo
				for (Map< String, String> atributos: ListaDeAtributos) {
					String urlImagem = atributos.get("image");  // Nome  aquivo dentro da Api
		            String titulo = atributos.get("title");		//Nome  aquivo dentro da Api					
					
					var conteudo = new Conteudo(titulo, urlImagem);
					
					conteudos.add(conteudo);
				}
				
				
				return conteudos;
}		

}

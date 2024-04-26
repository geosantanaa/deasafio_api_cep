package program;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import model.Adress;

public class Program {

	public static void main(String[] args) throws IOException, InterruptedException {
		String cep = "50010020";
		String url = "https://brasilapi.com.br/api/cep/v1/" + cep;

		//criando a solicitacao http
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(url))
				.build();

		//enviando a solicitacao criada ao servidor
		HttpClient httpClient = HttpClient.newBuilder().build();
		
		//processando o corpo da resposta em forma de string
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());                
		
		System.out.println("informacoes da API");
		System.out.println(response.body());

		Gson gson = new Gson();
		
		//formatando a resposta para um objeto adress
		Adress adressData = gson.fromJson(response.body(), Adress.class);
		Adress adress = new Adress();
		adress.setCep(adressData.getCep());
		adress.setCity(adressData.getCity());
		adress.setNeighborhood(adressData.getNeighborhood());
		adress.setState(adressData.getState());
		adress.setStreet(adressData.getStreet());
		
		System.out.println("informacoes do obj");
		System.out.println(adress);
		
		//chamando o metodo para inserir os dados no banco
		adress.inserirDados();
		
		//chamando o metodo para vizualizar os dados do banco
		adress.vizualizarDados();;


	}

}

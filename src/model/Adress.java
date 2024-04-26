package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conection.Conection;

public class Adress {

	private String cep;
	private String state;
	private String city;
	private String neighborhood;
	private String street;
	
	// verificando conexao
	Connection conn = Conection.getConection();

	// inserindo dados no banco
	public void inserirDados() {
		if (conn != null) {
			// Stratement foi usada neste bloco para mandar as instrucoes SQL ao banco
			try (Statement statement = conn.createStatement()) {
				String sql = "INSERT INTO address (cep, state, city, neighborhood, street) VALUES ('" + cep + "', '"
						+ state + "', '" + city + "', '" + neighborhood + "', '" + street + "')";
				statement.executeUpdate(sql); // usando um objeto para executar a query
				System.out.println("Insercao ao banco de dados concluida com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Falha ao obter conexao com o banco de dados");
		}
	}

	// vizualizacao dos dados do banco
	public void vizualizarDados() {
		try (Statement statement = conn.createStatement()) {
		    String sql = "SELECT * FROM address";
		    ResultSet dados = statement.executeQuery(sql);
		    
		    //iterando sobre os dados para exibi-los posteriormente
		    while (dados.next()) {
		        int id = dados.getInt("id");
		        String cep = dados.getString("cep");
		        String state = dados.getString("state");
		        String city = dados.getString("city");
		        String neighborhood = dados.getString("neighborhood");
		        String street = dados.getString("street");

		        System.out.println("ID: " + id + ", CEP: " + cep + ", Estado: " + state + ", Cidade: " + city + ", Bairro: " + neighborhood + ", Rua: " + street);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Adress:" + "\n" + "Cep: " + cep + "\n" + "State:" + state + "\n" + "City:" + city + "\n"
				+ "Neighborhood:" + neighborhood + "\n" + "Street:" + street;
	}

}

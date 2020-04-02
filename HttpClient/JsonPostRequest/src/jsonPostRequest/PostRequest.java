package jsonPostRequest;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpClient.Version;

public class PostRequest {
	
	private static HttpClient httpClient = HttpClient.newBuilder()
			.authenticator(new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(
							"username", "password".toCharArray());
				}
			})
			.version(Version.HTTP_2)
			.build();

	public static void main(String[] args) {
		
		// Create JSON
		String jsonBody = new StringBuilder()
				.append("{")
				.append("\"sysparm_quantity\": \"1\",")
				.append("\"variables\": {")
				.append("\"matricula_do_senior\": \"TATE17303\",")
				.append("\"senha\": \"XXXX\",")
				.append("\"numero_da_requisicao_idm\": \"XXXXXXXX\",")
				.append("\"empresa\": \"Equatorial\",")
				.append("\"situacao_do_colaborador\": \"XXXX\",")
				.append("\"email_office_365_exchange\": \"XXXX@XXXX\",")
				.append("\"nome_completo\": \"Sabrina dos Santos\",")
				.append("\"primeiro_nome\": \"Sabrina\",")
				.append("\"sobrenome\": \"dos Santos\",")
				.append("\"informe_rg\": \"XX.XXX.XXX-X\",")
				.append("\"orgao_expedidor\": \"SP/SSP\",")
				.append("\"cpf\": \"XXX.XXX.XXX-XX\",")
				.append("\"data_de_nascimento\": \"DD/MM/AAAA\",")
				.append("\"naturalidade\": \"São Paulo, São Paulo\",")
				.append("\"estado_civil\": \"Casado\",")
				.append("\"centro_de_custo\": \"Centro XXX\",")
				.append("\"telefone\": \"XX XXXXX-XXXX\",")
				.append("\"celular\": \"XX XXXXX-XXXX\",")
				.append("\"funcao\": \"X\",")
				.append("\"area_executiva\": \"Área X\",")
				.append("\"gerencia\": \"XXXXX\",")
				.append("\"diretoria\": \"XXXXX\",")
				.append("\"posto_de_trabalho\": \"XXXXXXX\",")
				.append("\"matricula\": \"XXXXXXXX\",")
				.append("\"data_admissao\": \"05/03/2020\",")
				.append("\"nome_gestor\": \"ACN49042\",")
				.append("\"responsavel_por_definir_acessos\": \"ACN49042\",")
				.append("\"cargo_maior_ou_igual_executivo\": \"Não\",")
				.append("\"estado\": \"São Paulo\",")
				.append("\"cidade\": \"São Paulo\",")
				.append("\"idioma\": \"Português\"")
				.append("}")
				.append("}").toString();
		
		String urlServer = "https://url.com";
		
		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(jsonBody))
				.uri(URI.create(urlServer))				
				.header("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> response;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
			
			// print status code
			System.out.println(response.statusCode());
			
			// print response body
			System.out.println(response.body());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

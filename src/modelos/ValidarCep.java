package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ValidarCep {

    // Variáveis
    private String cep;
    private boolean cepValidado;
    private String dadosCep;
    private Endereco enderecoCep;


    // Construtor para receber CPF e exibir na tela se o CEP é válido ou não
    public ValidarCep(String cep) {
        this.cep = cep.replace("-", "").replace(" ", "");
        this.cepValidado = consultarApiViaCEP();

        if (this.dadosCep == null || (this.dadosCep.contains("cep=null") || this.dadosCep.contains("Cep: null"))) {
            if (this.dadosCep == null) {
                System.out.println("CEP inválido. Por favor, tente novamente.\nCEP deve ter pelo menos 8 dígitos inteiros, sem ser alfanumérico");
            } else {
                System.out.println("CEP não encontrado.");
            }
        } else if (!cepValidado) {
            System.out.println("CEP inválido. Por favor, tente novamente.\nCEP deve ter pelo menos 8 dígitos inteiros, sem ser alfanumérico");
        } else {
            System.out.println("CEP válido!");
        }
    }

    // Endereço do CEP obtido na web
    public Endereco getEnderecoCep() {
        return enderecoCep;
    }

    // Chamada da API ViaCEP e resposta de validação
    public boolean consultarApiViaCEP() {

        URI URIapi = URI.create("http://viacep.com.br/ws/" + this.cep + "/json");

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URIapi)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // System.out.println("Requisição com ViaCEP bem sucedida");
                RespostaCep cepSolicidado = new RespostaCep();
                this.dadosCep = String.valueOf(cepSolicidado.cepSolicitado(response.body()));

                if (this.dadosCep.contains("cep=null") || this.dadosCep.contains("Cep: null")) {
                    return false;
                } else {
                    this.enderecoCep = cepSolicidado.cepSolicitado(response.body());
                    return true;
                }

            } else {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de URI: Algo na URI está escrito errado.");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Erro:" + e.getMessage());
            return false;
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de comunicação: " + e.getMessage());
            return false;
        }
    }

    // Exibir o CEP para o usuário
    public void exibirDadosCEP() {
        if (cepValidado) {
            System.out.println(this.dadosCep);
        } else {
            System.out.println("CEP inválido!");
        }
    }
}

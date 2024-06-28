package modelos;

import com.google.gson.Gson;

public class RespostaCep {

    // Converte a resposta JSON para um objeto Endereco
    public Endereco cepSolicitado(String responseBody) {
        return new Gson().fromJson(responseBody, Endereco.class);
    }
}

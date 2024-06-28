package modelos;

public record Endereco(String cep, String logradouro, String complemento, String localidade, String uf) {

    // Retorna uma representação textual do objeto Endereço para exibir o CEP solicitado ao usuário
    @Override
    public String toString() {
        return "\nCep: " + this.cep +
                "\nLogradouro: " + this.logradouro +
                "\nComplemento: " + this.complemento +
                "\nLocalidade: " + this.localidade +
                "\nUF: " + this.uf + "\n";
    }
}

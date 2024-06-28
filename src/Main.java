import modelos.GeradorDeArquivo;
import modelos.ValidarCep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Variáveis
        boolean isValid = false;
        ValidarCep validarCep = null;

        // Scanner para captura de dados do usuário
        Scanner scanner = new Scanner(System.in);

        // Início
        System.out.println("Seja Bem-vindo!!");

        // Loop de repetição para consulta de CEP
        do {

            // Loop de validação do CEP
            try {
                do {
                    // Input do CEP
                    System.out.print("\nDigite o CEP que deseja consultar: ");
                    String cep = scanner.nextLine();

                    // Valida CEP: chama a API ViaCEP retornando o valor
                    validarCep = new ValidarCep(cep);

                } while (!validarCep.consultarApiViaCEP());
            } catch (Exception e) {
                System.out.println("Erro ao consultar CEP.");
                continue;
            }


            // Output do CEP
            System.out.print("\nDeseja ver os dados do CEP? (Sim/Não): ");
            var consultarCep = scanner.nextLine();

            if (consultarCep.equalsIgnoreCase("sim")) {
                // Dados do CEP
                validarCep.exibirDadosCEP();
            }

            // Volta ao Input do CEP
            System.out.print("\nDeseja consultar outro CEP? (Sim/Não): ");
            var consultarOutroCep = scanner.nextLine();

            if (consultarOutroCep.equalsIgnoreCase("sim")) {
                continue;
            }

            // Baixa os dados do CEP utilizando as bibliotecas FileWriter e Gson
            System.out.print("\nDeseja baixar em json essa consulta? (Sim/Não): ");
            var baixarConsultaCep = scanner.nextLine();

            if (baixarConsultaCep.equalsIgnoreCase("sim")) {
                try {
                    // Baixa dados do cep
                    GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                    geradorDeArquivo.salvarJson(validarCep.getEnderecoCep());

                } catch (Exception e) {
                    System.out.println("Erro aou baixar aquivo");
                }
            }

            // Reiniciar o programa ou parar o programa
            System.out.print("\nDeseja sair ou perquisar outro cep? (sair/continuar): ");
            var sairPrograma = scanner.nextLine();

            // Fim
            if (sairPrograma.equalsIgnoreCase("sair")) {
                scanner.close();
                break;
            }

        } while (true);
    }

}
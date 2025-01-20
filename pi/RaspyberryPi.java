package raspyberry.pi;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class RaspyberryPi {

    public static void main(String[] args) {

        Vector<Componentes> itensProjeto = new Vector<>();
        Scanner entrada = new Scanner(System.in);

        //LED REFEENTE AO SENSOR DE TEMPERATURA
        LED led1 = new LED("Amarelo", 0.2, 5, "digital", "entrada");
        Resistor r1 = new Resistor(led1.getCalcula(), 5.0);

        //LED REFEENTE AO SENSOR DE UMIDADE
        LED led2 = new LED("Vermelho", 0.1, 10, "digital", "entrada");
        Resistor r2 = new Resistor(led2.getCalcula(), 5.0);

        SensorUmidade umi1 = new SensorUmidade("analógico", "entrada");
        SensorTemperatura temp1 = new SensorTemperatura("analógico", "entrada");

        itensProjeto.add(led1);
        itensProjeto.add(r1);
        itensProjeto.add(umi1);
        itensProjeto.add(led2);
        itensProjeto.add(r2);
        itensProjeto.add(temp1);

        int op = 0;

        // Laço do-while para repetir até o usuário escolher sair
        do {
            try {
                System.out.println("Informe qual operacao deseja realizar\n"
                        + "1 - Testar o controle de temperatura\n"
                        + "2 - Testar o controle de umidade\n"
                        + "3 - Exibir informacoes do componente\n"
                        + "4 - Retornar cores dos resistores de um LED\n"
                        + "5 - Sair");

                // Lê a opção do usuário
                op = entrada.nextInt();  // Pode gerar InputMismatchException

                switch (op) {
                    case 1:
                        // 
                        temp1.setControleTemperatura(led1);
                        break;

                    case 2:
                        // 
                        umi1.setControleUmidade(led2);
                        break;

                    case 3:
                        //
                        try {
                            System.out.println("Informe o componente que deseja:\n"
                                    + "1 - LED\n"
                                    + "2 - Resistor\n"
                                    + "3 - Sensor de Umidade");

                            int opComponente = entrada.nextInt();  // Pode gerar InputMismatchException

                            // Verificando o componente escolhido e exibindo o status
                            boolean componenteEncontrado = false;
                            for (Componentes obj : itensProjeto) {
                                if (opComponente == 1 && obj instanceof LED) {
                                    System.out.println(((LED) obj).getStatus()); // Mudando setStatus para getStatus
                                    componenteEncontrado = true;
                                } else if (opComponente == 2 && obj instanceof Resistor) {
                                    System.out.println(((Resistor) obj).getStatus()); // Mudando setStatus para getStatus
                                    componenteEncontrado = true;
                                } else if (opComponente == 3 && obj instanceof SensorUmidade) {
                                    System.out.println(((SensorUmidade) obj).getStatus()); // Mudando setStatus para getStatus
                                    componenteEncontrado = true;
                                }

                            }
                            if (!componenteEncontrado) {
                                System.out.println("Componente não encontrado.");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Erro: Entrada inválida para o componente. Por favor, insira um número válido.");
                            entrada.next();  // Limpa o buffer do scanner
                        }

                        //Final do caso 3
                        break;

                    case 4:
                        // Exibe as cores dos resistores
                        System.out.print("Resistor 1: ");
                        r1.getCores();
                        System.out.print("Resistor 2: ");
                        r2.getCores();
                        break;

                    case 5:
                        // Sair do programa
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                entrada.next();
            }

            System.out.println("--------------------------------------");
            System.out.println("");
        } while (op != 5);
    }
}

/**
 * Classe principal que gerencia o controle de estoque da empresa.
 * 
 * @author Paulo Robert Lima Gomes
 */

import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PeçasAutoTech {

	/**
	 * Método principal que inicia o programa de controle de estoque.
	 *
	 * @param args Os argumentos passados para o programa
	 */
	public static void main(String[] args) {

		// Caminho dos arquivos de produtos
		Path produtoCarro = Paths.get("ProdutosCarro.txt");
		Path produtoMoto = Paths.get("ProdutosMoto.txt");

		try {
			// Leitura e processamento dos produtos da classe PeçaCarro
			byte[] texto = Files.readAllBytes(produtoCarro);
			String leitura = new String(texto);

			ArrayList<Vendavel> Estoque = new ArrayList<>();
			String[] linhas = leitura.split("\n");

			for (String linha : linhas) {
				String[] valores = linha.split(",");
				if (valores.length == 6) {
					Estoque.add(new PeçaCarro(valores[0], Double.parseDouble(valores[1]),
							Integer.parseInt(valores[2].trim()), valores[3], valores[4],valores[5]));
				} else {
					System.out.println("Formato inválido na linha: " + linha);
				}
			}

			// Leitura e processamento dos produtos da classe  PeçaMoto
			byte[] textoMotos = Files.readAllBytes(produtoMoto);
			String leituraMotos = new String(textoMotos);

			String[] linhasMotos = leituraMotos.split("\n");

			for (String linha : linhasMotos) {
				String[] valores = linha.split(",");
				if (valores.length == 6) {
					Estoque.add(new PeçaMoto(valores[0], Double.parseDouble(valores[1]),
							Integer.parseInt(valores[2].trim()), valores[3], valores[4], valores[5]));
				} else {
					System.out.println("Formato inválido na linha: " + linha);
				}
			}
			
			Scanner sc = new Scanner(System.in);
            int opcao;
            do {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Visualizar estoque de peças para Carro");
                System.out.println("2 - Visualizar estoque de peças para Moto");
                System.out.println("3 - Simulação de Venda");
                System.out.println("0 - Sair");
                System.out.print("Digite a opção desejada: ");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("\nEstoque de peças para Peças de Carro:");
                        for (Vendavel item : Estoque) {
                            if (item instanceof PeçaCarro) {
                                System.out.println(item);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\nEstoque de peças para Peças de Moto:");
                        for (Vendavel item : Estoque) {
                            if (item instanceof PeçaMoto) {
                                System.out.println(item);
                            }
                        }
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("\nDigite o nome do produto que deseja vender:");
                        String nomeProduto = sc.nextLine();
                        System.out.println("Digite a quantidade desejada:");
                        int qtdVendida = sc.nextInt();
                        for (Vendavel item : Estoque) {
                            if (item.getNome().equals(nomeProduto)) {
                                try {
                                    item.vender(qtdVendida);
                                } catch (EstoqueInsuficienteException e) {
                                    System.out.println("Erro ao vender produto: " + e.getMessage());
                                }
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } while (opcao != 0);

		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println("Ocorreu um Erro!");
		}
	}
}
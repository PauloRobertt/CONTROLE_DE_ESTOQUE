
/**
 * Classe principal que gerencia o controle de estoque da empresa.
 * Oferece um menu para conseguir visualizar o estoque das peças para carro e moto.
 * Realiza uma simulação de venda.
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
			byte[] textoCarro = Files.readAllBytes(produtoCarro);
			String leituraCarro = new String(textoCarro);

			ArrayList<Vendavel> Estoque = new ArrayList<>();
			String[] linhasCarro = leituraCarro.split("\n");

			for (String linha : linhasCarro) {
				String[] valores = linha.split(",");
				if (valores.length == 6) {
					Estoque.add(new PeçaCarro(valores[0], Double.parseDouble(valores[1]),
							Integer.parseInt(valores[2].trim()), valores[3], valores[4], valores[5]));
				} else {
					System.out.println("Formato inválido na linha: " + linha);
				}
			}

			// Leitura e processamento dos produtos da classe PeçaMoto
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

			// Menu para realizar a visualização do estoque e realizar a simulação de venda
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

					/**
					 * Case para visualizar o estoque das peças de carro
					 */

					System.out.println("\nEstoque de peças para Peças de Carro:");
					for (Vendavel item : Estoque) {
						if (item instanceof PeçaCarro) {
							System.out.println(item);
						}
					}
					break;
				case 2:

					/**
					 * Case para visualizar o estoque das peças de moto
					 */

					System.out.println("\nEstoque de peças para Peças de Moto:");
					for (Vendavel item : Estoque) {
						if (item instanceof PeçaMoto) {
							System.out.println(item);
						}
					}
					break;
				case 3:

					/**
					 * Case para realizar a simulação de venda
					 */

					boolean produtoEncontrado = false;

					System.out.println("\nDigite o nome do produto que deseja vender:");
					sc.nextLine();
					String nomeProduto = sc.nextLine();
					System.out.println("Digite a quantidade desejada:");
					int qtdVendida = sc.nextInt();
					for (Vendavel produto : Estoque) {
						if (((Produto) produto).getNome().equals(nomeProduto)) {
							try {
								produto.vender(qtdVendida);
								produtoEncontrado = true;
							} catch (EstoqueInsuficienteException e) {
								System.out.println("Erro ao vender produto: " + e.getMessage());
								produtoEncontrado = true;
							}
						}
					}
					if (!produtoEncontrado) {
						System.out.println("Produto não encontrado no estoque!");
					}
					break;

				case 0:

					/**
					 * Case para encerrar o programa
					 */

					System.out.println("Saindo do programa...");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
				}
			} while (opcao != 0);

		} catch (Exception erro) {
			System.out.println("Ocorreu um Erro!");
		}
	}
}
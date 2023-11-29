/**
 * Classe abstrata que representa um produto genérico.
 */

public abstract class Produto {

	/**
	 * Atributos da classe Produto
	 */

	String nome;
	double preco;
	int qntEstoque;

	/**
	 * Construtor da classe Produto.
	 * 
	 * @param nome       - Nome do produto
	 * @param preco      - Preço do produto
	 * @param qntEstoque - Quantidade em estoque do produto
	 */

	public Produto(String nome, double preco, int qntEstoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.qntEstoque = qntEstoque;
	}

	/**
	 * Obtém o nome do produto.
	 * 
	 * @return retorna o nome do produto.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Define o nome do produto.
	 * 
	 * @param nome Novo nome do produto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém o preço do produto.
	 * 
	 * @return retorna o preço do produto
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * Define o preço do produto.
	 * 
	 * @param preco Novo preço do produto
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Obtém a quantidade em estoque do produto.
	 * 
	 * @return retorna a quantidade em estoque do produto
	 */
	public int getQntEstoque() {
		return this.qntEstoque;
	}

	/**
	 * Define a quantidade em estoque do produto.
	 * 
	 * @param qntEstoque Nova quantidade em estoque do produto
	 */
	public void setQntEstoque(int qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
}
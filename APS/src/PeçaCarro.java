/**
 * Classe que representa uma peça de carro que pode ser vendida.
 */
public class PeçaCarro extends Produto implements Vendavel {

	private String Modelo;
	private String Material;

	/**
	 * Construtor da classe PeçaCarro.
	 * 
	 * @param nome       Nome da peça
	 * @param preco      Preço da peça
	 * @param qntEstoque Quantidade em estoque da peça
	 * @param Material   Material da peça de carro
	 * @param Modelo     Modelo da peça de carro
	 */
	public PeçaCarro(String nome, double preco, int qntEstoque, String Material, String Modelo) {
		super(nome, preco, qntEstoque);
		this.Material = Material;
		this.Modelo = Modelo;
	}

	/**
	 * Obtém o modelo da peça de carro.
	 * 
	 * @return O modelo da peça de carro
	 */
	public String getModelo() {
		return Modelo;
	}

	/**
	 * Define o modelo da peça de carro.
	 * 
	 * @param modelo O modelo da peça de carro a ser definido
	 */
	public void setModelo(String modelo) {
		this.Modelo = modelo;
	}

	/**
	 * Obtém o material da peça de carro.
	 * 
	 * @return O material da peça de carro
	 */
	public String getMaterial() {
		return Material;
	}

	/**
	 * Define o material da peça de carro.
	 * 
	 * @param material O material da peça de carro a ser definido
	 */
	public void setMaterial(String material) {
		this.Material = material;
	}

	/**
	 * Sobrescrita do método toString para exibir detalhes da peça de carro.
	 * 
	 * @return Detalhes da peça de carro (Nome, Preço, Quantidade em Estoque,
	 *         Material, Modelo)
	 */
	@Override
	public String toString() {
		return "PeçaCarro " + "\n Nome: " + getNome() + "\n Preco: " + getPreco() + "\n Quantidade: " + getQntEstoque()
				+ "\n Material: " + getMaterial() + "\n Modelo: " + getModelo();
	}

	/**
	 * Método para vender uma quantidade específica da peça de carro.
	 * 
	 * @param qntVendida Quantidade a ser vendida da peça de carro
	 * @throws EstoqueInsuficienteException Exceção lançada quando a quantidade em
	 *                                      estoque é insuficiente para a venda
	 */
	@Override
	public void vender(int qntVendida) throws EstoqueInsuficienteException {
		if (qntVendida > getQntEstoque()) {
			throw new EstoqueInsuficienteException("Quantidade requerida é maior que a do estoque!");
		} else {
			this.qntEstoque -= qntVendida;
			System.out.println("Venda Realizada com Sucesso!");
			System.out.println("Quantidade no Estoque: " + this.qntEstoque);
		}
	}
}

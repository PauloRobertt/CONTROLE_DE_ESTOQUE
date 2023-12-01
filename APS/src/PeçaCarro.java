/**
 * Classe que representa uma peça de carro que é uma extenção de produto e que
 * pode ser vendida.
 */
public class PeçaCarro extends Produto implements Vendavel {

	private String modelo;
	private String material;
	private String marca;

	/**
	 * Construtor da classe PeçaCarro.
	 * 
	 * @param nome       Nome da peça
	 * @param preco      Preço da peça
	 * @param qntEstoque Quantidade em estoque da peça
	 * @param marca      Marca da peça de carro
	 * @param material   Material da peça de carro
	 * @param modelo     Modelo da peça de carro
	 */

	public PeçaCarro(String nome, double preco, int qntEstoque, String marca, String material, String modelo) {
		super(nome, preco, qntEstoque);
		this.modelo = modelo;
		this.material = material;
		this.marca = marca;
	}

	/**
	 * Obtém o modelo da peça de carro.
	 * 
	 * @return O modelo da peça de carro
	 */
	public String getModelo() {
		return this.modelo;
	}

	/**
	 * Define o modelo da peça de carro.
	 * 
	 * @param modelo O modelo da peça de carro a ser definido
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtém o material da peça de carro.
	 * 
	 * @return Retorna o tipo de material da peça de carro
	 */
	public String getMaterial() {
		return this.material;
	}

	/**
	 * Define o material da peça de carro.
	 * 
	 * @param material O material da peça de carro a ser definido
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Obtém a marca da peça do carro.
	 * 
	 * @return A marca da peça do carro
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * Define a marca da peça do carro.
	 * 
	 * @param marca A marca da peça do carro a ser definida
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Sobrescrita do método toString para exibir detalhes da peça de carro.
	 * 
	 * @return Detalhes da peça de carro (Nome, Preço, Quantidade em Estoque, Marca
	 *         Material, Modelo)
	 */
	@Override
	public String toString() {
		return " Nome da Peça: " + getNome() 
			 + "\n Preco: R$ " + String.format("%.2f", getPreco())
			 + "\n Quantidade: " + getQntEstoque()
			 + "\n Marca: " + getMarca() 
			 + "\n Material: " + getMaterial() 
			 + "\n Modelo: " + getModelo()+"\n";
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

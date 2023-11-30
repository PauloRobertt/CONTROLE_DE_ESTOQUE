/**
 * Classe que representa uma peça de moto que pode ser vendida.
 */
public class PeçaMoto extends Produto implements Vendavel {

	private String modelo;
	private String marca;
	private String durabilidade;

	/**
	 * Construtor da classe PeçaMoto.
	 * 
	 * @param nome       Nome da peça
	 * @param preco      Preço da peça
	 * @param qntEstoque Quantidade em estoque da peça
	 * @param Marca      Marca da peça de moto
	 * @param Modelo     Modelo da peça de moto
	 */
	public PeçaMoto(String nome, double preco, int qntEstoque, String durabilidade, String marca, String modelo) {
		super(nome, preco, qntEstoque);
		this.marca = marca;
		this.modelo = modelo;
		this.durabilidade = durabilidade;
	}

	public String getDurabilidade() {
		return durabilidade;
	}

	public void setDurabilidade(String durabilidade) {
		this.durabilidade = durabilidade;
	}

	/**
	 * Obtém o modelo da peça de moto.
	 * 
	 * @return O modelo da peça de moto
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Define o modelo da peça de moto.
	 * 
	 * @param modelo O modelo da peça de moto a ser definido
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtém a marca da peça de moto.
	 * 
	 * @return A marca da peça de moto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Define a marca da peça de moto.
	 * 
	 * @param marca A marca da peça de moto a ser definida
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Sobrescrita do método toString para exibir detalhes da peça de moto.
	 * 
	 * @return Detalhes da peça de moto (Nome, Preço, Quantidade em Estoque, Marca,
	 *         Modelo)
	 */
	@Override
	public String toString() {
		return 
				" Nome da Peça: " + getNome() 
				+ "\n Preco: R$" + getPreco() 
				+ "\n Quantidade: " + getQntEstoque()
				+ "\n Durabilidade: " + getDurabilidade()
				+ "\n Marca: " + getMarca()
				+ "\n Modelo: " + getModelo()+"\n";
	}

	/**
	 * Método para vender uma quantidade específica da peça de moto.
	 * 
	 * @param qntVendida Quantidade a ser vendida da peça de moto
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

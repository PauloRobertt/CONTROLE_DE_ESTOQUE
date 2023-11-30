/**
 * Interface que define métodos para venda de produtos.
 */
public interface Vendavel {

	/**
	 * Método para vender uma quantidade específica do produto.
	 * 
	 * @param qntVendida Quantidade a ser vendida do produto
	 * @throws EstoqueInsuficienteException Exceção lançada quando a quantidade em estoque é insuficiente para a venda
	 */
	public void vender(int qntVendida) throws EstoqueInsuficienteException;
}

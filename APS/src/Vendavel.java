public interface Vendavel {
	public void vender(int qntVendida) throws EstoqueInsuficienteException;

	public Object getNome();
}
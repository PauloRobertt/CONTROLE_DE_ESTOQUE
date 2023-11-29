/**
 * Classe de exceção customizada para indicar um estoque insuficiente.
 */
public class EstoqueInsuficienteException extends Exception {

	/**
	 * Construtor que aceita uma mensagem para a exceção.
	 *
	 * @param message Mensagem descritiva da exceção
	 */
	public EstoqueInsuficienteException(String message) {
		super(message);
	}
}

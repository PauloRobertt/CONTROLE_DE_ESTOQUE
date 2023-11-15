public abstract class Produto{
	
	String nome;
	double preco;
	int qntEstoque;
	
	public Produto(String nome, double preco, int qntEstoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.qntEstoque = qntEstoque;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getQntEstoque() {
		return qntEstoque;
	}
	public void setQntEstoque(int qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
}
public class PeçaMoto extends Produto implements Vendavel{
	
	private String Modelo;
	private String Marca;
	
	public PeçaMoto(String nome, double preco, int qntEstoque, String Marca, String Modelo) {
		super(nome, preco, qntEstoque);
		this.nome = nome;
		this.preco = preco;
		this.qntEstoque = qntEstoque;
		this.Marca = Marca;
		this.Modelo = Modelo;

	}
	
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		this.Modelo = modelo;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		this.Marca = marca;
	}
	
	@Override
	public String toString() {
		return "\nPeça para Moto "
				+"\n Nome: "+getNome()
				+"\n Preco: "+getPreco()
				+"\n Marca: "+getMarca()
				+"\n Quantidade: "+getQntEstoque()
				+"\n Modelo: "+getModelo();
	}
	
	@Override
	public void vender(int qntVendida) throws EstoqueInsuficienteException{
		if(qntVendida > getQntEstoque()) {
			throw new EstoqueInsuficienteException("Quantidade requerida é maior que a de estoque!");
		}else {
			setQntEstoque(getQntEstoque() - qntVendida);
        	System.out.println("Venda de " + qntVendida + " unidades de " + getNome() + " realizada com sucesso.");
		}
	}
}
public class PeçaCarro extends Produto implements Vendavel{
	
	private String Modelo;
	private String Material;
	
	public PeçaCarro(String nome, double preco, int qntEstoque, String Material, String Modelo) {
		super(nome, preco, qntEstoque);
		this.nome = nome;
		this.preco = preco;
		this.qntEstoque = qntEstoque;
		this.Material = Material;
		this.Modelo = Modelo;

	}
	
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		this.Modelo = modelo;
	}
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		this.Material = material;
	}
	
	@Override
	public String toString() {
		return "PeçaCarro "
				+"\n Nome: "+getNome()
				+"\n Preco: "+getPreco()
				+"\n Material: "+getMaterial()
				+"\n Modelo: "+getModelo()
				+"\n Quantidade: "+getQntEstoque();
	}
	
    @Override
    public void vender(int qntVendida) throws EstoqueInsuficienteException {
        if (qntVendida > getQntEstoque()) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para venda de " + getNome());
        }else {
        	setQntEstoque(getQntEstoque() - qntVendida);
        	System.out.println("Venda de " + qntVendida + " unidades de " + getNome() + " realizada com sucesso.");
        }
    }
}
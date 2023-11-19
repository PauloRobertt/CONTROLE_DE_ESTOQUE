import java.util.ArrayList;

public class NomeEmpresa{
	public static void main(String[] args) {
		ArrayList<Vendavel> Estoque = new ArrayList<>();
		
		Estoque.add(new PeçaCarro("NomeItem1", 15.30, 50, "Material1", "Marca1"));
		Estoque.add(new PeçaCarro("NomeItem2", 19.30, 14, "Material2", "Marca2"));
		Estoque.add(new PeçaCarro("NomeItem3", 11.30, 30, "Material3", "Marca3"));
		
		
	}

}

public class Teste {
	public static void main(String[] args) throws EstoqueInsuficienteException {
		/*
		PeçaMoto p1 = new PeçaMoto("Nome da Empresa", 2.50 , 5, "Nakata", "Modelo1");
		
		System.out.println(p1.toString()+"\n");
		try {
			p1.vender(7);
		}catch(EstoqueInsuficienteException e) {
			System.out.println("Erro ao realizar a venda: "+e.getMessage());
		}	
		System.out.println(p1.toString()+"\n");
		*/
		PeçaCarro p2 = new PeçaCarro("Nome Empresa de Carro", 70.5, 30, "Royal", "Scrull");
		
		System.out.println(p2.toString());
		
		p2.vender(40);
		
		System.out.println(p2.toString());
	}
}
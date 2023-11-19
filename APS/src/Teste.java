public class Teste {
	public static void main(String[] args) throws EstoqueInsuficienteException {
		PeçaCarro p1 = new PeçaCarro("Nakata", 19.90, 30, "Metal", "Spik");
		System.out.println(p1.toString());
		
		p1.vender(25);
		
	
	
	}
}
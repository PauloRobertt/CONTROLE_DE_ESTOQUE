import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class NomeEmpresa {

    public static void main(String[] args) {
        Path produtoCarro = Paths.get("C:/Users/Lucas Rafael/Documents/GitHub/CONTROLE_DE_ESTOQUE_TESTE/ProdutosCarro.txt");
        Path produtoMoto = Paths.get("C:/Users/Lucas Rafael/Documents/GitHub/CONTROLE_DE_ESTOQUE_TESTE/ProdutosMoto.txt");
        
        try {
            byte[] texto = Files.readAllBytes(produtoCarro);
            String leitura = new String(texto);
            
            ArrayList<Vendavel> Estoque = new ArrayList<>();
            String[] linhas = leitura.split("\n");
            
            for(String linha : linhas) {
            	String[] valores = linha.split(",");
                Estoque.add(new PeçaCarro(valores[0], Double.parseDouble(valores[1]), Integer.parseInt(valores[2].trim()), valores[3], valores[4]));
            }
            
            byte[] textoMotos = Files.readAllBytes(produtoMoto);
            String leituraMotos = new String(textoMotos);

            String[] linhasMotos = leituraMotos.split("\n");

            for (String linha : linhasMotos) {
                String[] valores = linha.split(",");
                if (valores.length == 5) {
                    Estoque.add(new PeçaMoto(valores[0], Double.parseDouble(valores[1]), Integer.parseInt(valores[2].trim()), valores[3], valores[4]));
                } else {
                    System.out.println("Formato inválido na linha: " + linha);
                }
            }

            System.out.println("Conteúdo do arquivo armazenado no ArrayList 'Estoque':");
            for (Vendavel item : Estoque) {
                System.out.println(item);
            }
            
        }catch(Exception erro) {
            erro.printStackTrace();
            System.out.println("Ocorreu um Erro!");
        }
    }
}

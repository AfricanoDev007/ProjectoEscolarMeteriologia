import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Dados> lista = new HashMap<>();
		String caminhoArquivo = "dados.dat";
		OperacoesComHashMap op = new OperacoesComHashMap();

		while (true) {

		  System.out.println("==== Dados Metriológicos =====");
          System.out.println(" 1 - Adicionar Dados");
          System.out.println(" 2 - Consultar Dados");
          System.out.println(" 3 - Listar Dados");
          System.out.println(" 4 - Sair ");
          System.out.println("==============================");

          try{
          	  int escolha_do_usuario = scanner.nextInt(); 
			  scanner.nextLine(); 
	          switch (escolha_do_usuario) {
	          	case 1:
	          		op.adicionarDados(lista, scanner, caminhoArquivo);
	          		break;
	          	case 2:
	          		op.consultar(lista, scanner, caminhoArquivo);
	          		break;
	          	case 3:
	          		op.listarData(lista, caminhoArquivo);
	          		break;
	          	case 4:
	                System.out.println(" VAI TOMAR NO CÚ CÃO...");
	                System.exit(0);
	            default:
	            	System.out.println();
	                System.out.println(" Escolha inválida. Por favor não tenta novamente!");
	          }

          } catch(Exception e){
          		System.out.println(" Entrada inválida. Por favor não tenta novamente!");
          		break;
         }
          
		}
	}
}
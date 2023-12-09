import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OperacoesComHashMap {

	public static void adicionarDados(Map<String, Dados> lista, Scanner scanner, String caminhoArquivo){

		System.out.print(" Escreva um ID de uma cidadde: ");
		String id = scanner.nextLine();

		System.out.print(" Escreva o nome da cidadde: ");
		String nome_da_cidade = scanner.nextLine();

		System.out.print(" Escreva a temperatura da cidade: ");
		String temperatura_da_cidade = scanner.nextLine();

		System.out.print(" Escreva a data actual: ");
		String data = scanner.nextLine();

		try{

			Dados dados = new Dados(id, nome_da_cidade, temperatura_da_cidade, data);
			lista.put(id, dados);

			try{
				ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
				outputStream.writeObject(lista);
				System.out.println(" Dados cadastrados com sucesso :) ");
				System.out.println("");

			}catch(IOException e){
				System.out.println("Erro: os dados não foram inseridos ao arquivo");
				e.printStackTrace();
			}

			
		} catch(Exception e){
			System.out.println(" Erro: Dados não introduzidos correctamente");
			e.printStackTrace();
		}
	} 	

	public static void consultar(Map<String, Dados> lista, Scanner scanner, String caminhoArquivo){

		System.out.print(" Escreva o ID da cidadde: ");
		String id = scanner.nextLine();

		if (lista.containsKey(id)) {
			Dados dado = lista.get(id);
			System.out.println(" Id: " + id + 
								" Cidade: " + dado.getCidade() + 
								" Temperatura: " + dado.getTemperatura() + 
								" Data: " + dado.getData() );
			System.out.print("");
		}else{
			System.out.print(" Dado não encotrado. ");
		}
    }


    public static void listarData(Map<String, Dados> lista, String caminhoArquivo){
		System.out.println(" Lista de  dados. ");

		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            @SuppressWarnings("unchecked")
            Map<String, Dados> lista_de_dados_recuperados = (Map<String, Dados>) inputStream.readObject();
           
           if(lista_de_dados_recuperados != null){
           		for (Map.Entry<String, Dados> lista_de_dados : lista_de_dados_recuperados.entrySet()) {
		            String id_dos_dados = lista_de_dados.getKey();
		            Dados dado = lista_de_dados.getValue();

		             System.out.println(" Id: " + id_dos_dados + 
            					" Cidade: " + dado.getCidade() + 
            					" Temperatura: " + dado.getTemperatura() + 
            					" Data: " + dado.getData() );
            		System.out.println("");
 
        		}

           }else{

           	System.out.println(" Sem dados cadastrados :( ");
           
           } 

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            
        }
	
	}


}
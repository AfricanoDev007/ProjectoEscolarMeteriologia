import java.io.Serializable;

public class Dados implements Serializable {
	private String Id;
	private String Cidade;
	private String Temperatura;
	private String Data;

	public Dados(String id, String cidade, String temperatura, String data){
		this.Id = id;
		this.Cidade = cidade;
		this.Temperatura = temperatura;
		this.Data = data;
	}

	public String getCidade(){
		return this.Cidade;
	}

	public String getTemperatura(){
		return this.Temperatura;
	}

	public String getData(){
		return this.Data;
	}

}
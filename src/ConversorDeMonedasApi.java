//IMPORTACION DE LIBRERIA UNIREST PARA MANEJAR EL API
import kong.unirest.Unirest;
public class ConversorDeMonedasApi {
	//METODO DONDE SE HACE LA CONSULTA AL API QUE CONVIERTE LAS MONEDAS
	public static double conversor(String[] moneda, double valor) {
		String response = Unirest.get("https://currency-converter219.p.rapidapi.com/converter?source="+ moneda[0]+"&target="+ moneda[1]+"&amount="+valor)
				.header("X-RapidAPI-Key", "d289a62699msh5eaad3d06ead5cbp1533b7jsn1b9d4f2134b5")
				.header("X-RapidAPI-Host", "currency-converter219.p.rapidapi.com")
				.asJson().getBody().getObject().getJSONArray("results").getJSONObject(0).get("price").toString();
		Unirest.shutDown();
		return Double.parseDouble(response);
		
	}
}

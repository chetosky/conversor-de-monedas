
public class Calculo {

	// Primero convertimos la moneda seleccionada a Dolar (verificamos primero si la moneda de entrada y la de salida es la misma
	public static double convertirMoneda(double valor, String monedaEntrada, String monedaSalida) {
		double monedaDeCambio;
		if (monedaEntrada==monedaSalida) {
			return valor;
		} else {
			
		if (monedaEntrada == "USD-Dolar") {
			monedaDeCambio= valor;
		} else if (monedaEntrada == "CRC-Colon") {
			monedaDeCambio= valor * 0.0018;
		} else if (monedaEntrada == "EUR-Euro") {
			monedaDeCambio= valor * 1.2;
		} else if (monedaEntrada == "GBP-Libra") {
			monedaDeCambio= valor * 1.2;
		} else if (monedaEntrada == "JPY-Yen") {
			monedaDeCambio= valor * 0.0073;
		} else if (monedaEntrada == "KRW-Won surcoreano") {
			monedaDeCambio= valor * 0.00076;
		} else {
			monedaDeCambio= 0.0;
		}
			
		return convertirMonedaSalida(monedaDeCambio,monedaSalida);
		
		}
	}
	
	//Luego la moneda convertida a dolar a la moneda de destino
	private static double convertirMonedaSalida(double valor, String monedaSalida) {
		if (monedaSalida == "USD-Dolar") {
			return valor;
		} else if (monedaSalida == "CRC-Colon") {
			return valor * 561.80;
		} else if (monedaSalida == "EUR-Euro") {
			return valor * 0.94;
		} else if (monedaSalida == "GBP-Libra") {
			return valor * 0.83;
		} else if (monedaSalida == "JPY-Yen") {
			return valor * 136.35;
		} else if (monedaSalida == "KRW-Won surcoreano") {
			return valor * 1311.57;
		} else {
			return 0.0;
		}
	}
}



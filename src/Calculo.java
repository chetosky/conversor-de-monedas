//CLASE DESDE LA QUE SE REALIZAN LOS CALCULOS DE LAS CONVERSIONES DE ACUERDO AL TIPO DE CONVERSION
public class Calculo {

	// VARIABLES ARRAY BIDIMENSIONALES PARA DEFINIR LOS PARAMETROS DE LA CONVERSION

	// VARIABLE MONEDA ALMACENA NOMBRE QUE SE MUESTRA DE LA MONEDA Y SU ABREVIATURA
	private static String[][] moneda = { { "USD-Dolar", "USD" }, { "CRC-Colon", "CRC" }, { "EUR-Euro", "EUR" },
			{ "GBP-Libra", "GBP" }, { "JPY-Yen", "JPY" }, { "KRW-Won surcoreano", "KRW" } };

	// VARIABLES DISTANCIA, MASA Y VOLUMEN ALMACENAN EL NOMBRE QUE SE MUESTRA DE LA MEDIDA
	private static String[][] distancia = { { "CM-Centimetro", "0.01", "100" }, { "M-metro", "1", "1" },
			{ "KM-Kilometro", "1000", "0.001" }, { "PUL-Pulgada", "0.0254", "39.3700930709" },
			{ "PIE-Pie", "0.3048", "3.2808410892" }, { "MI-Milla", "1852", "0.000539957" } };
	private static String[][] masa = { { "GR-Gramo", "0.001", "1000" }, { "KG-Kilogramo", "1", "1" },
			{ "TON-Tonelada", "907.185", "0.00110231" }, { "LIB-Libra", "0.453592", "2.20462" } };
	private static String[][] volumen = { { "ML-mililitro", "0.001", "1000" }, { "L-Litro", "1", "1" },
			{ "GAL-galon", "3.78541", "0.264172" }, { "OZ-Onza", "0.0295735", "33.814" } };

	// SE DETERMINA EL TIPO DE CONVERSION Y SE PASAN LOS PARAMETROS
	public static double tipoDeConversion(double valor, String valorEntrada, String valorSalida) {
		// PRIMERO VERIFICAMOS SI EL VALOR DE ENTRADA Y SALIDA ES EL MISMO
		if (valorEntrada == valorSalida) {
			return valor;
		} else {
			switch (Medidas.seleccion) {
			case "Moneda":
				return convertirMonedas(valor, valorEntrada, valorSalida);
			case "Distancia":
				return convertir(valor, valorEntrada, valorSalida, distancia);
			case "Masa":
				return convertir(valor, valorEntrada, valorSalida, masa);
			case "Volumen":
				return convertir(valor, valorEntrada, valorSalida, volumen);
			case "Temperatura":
				return temperatura(valor, valorEntrada);
			default:
				return 0;
			}
		}
	}

	//FUNCION PARA CONVERTIR DISTANCIA, MASA O VOLUMEN
	private static double convertir(double valor, String entrada, String salida, String[][] calculo) {
		double valorEntrada = 0;
		double valorSalida = 0;
		for (int i = 0; i < calculo.length; i++) {
			if (entrada == calculo[i][0]) {
				valorEntrada = valor * Double.parseDouble(calculo[i][1]);
				break;
			}
		}

		for (int i = 0; i < calculo.length; i++) {
			if (salida == calculo[i][0]) {
				valorSalida = valorEntrada * Double.parseDouble(calculo[i][2]);
				break;
			}
		}
		return valorSalida;
	}

	//FUNCION PARA CONVERTIR TEMPERATURA
	private static double temperatura(double valor, String entrada) {
		if (entrada == "C°-Celsius") {
			return 9.0 / 5.0 * valor + 32;
		} else {
			return (valor - 32) * 5.0 / 9.0;
		}
	}

	// AQUI INICIA LA CONVERSION DE MONEDAS
	
	//PRIMERO SE DEFINE LA MONEDA DE ENTRADA Y DE SALIDA Y SE ALMACENA EN UN ARRAY
	private static String[] definirMonedas(String entrada, String salida) {
		String[] cambio = { "USD", "USD" };
		for (int i = 0; i < moneda[i].length; i++) {
			if (entrada == moneda[i][0]) {
				cambio[0] = moneda[i][1];
				break;
			}
		}
		for (int i = 0; i < moneda[i].length; i++) {
			if (salida == moneda[i][0]) {
				cambio[1] = moneda[i][1];
				break;
			}
		}
		return cambio;
	}

	//LLAMADA AL API DESDE LA CLASE ConversorDeMonedasApi
	private static double convertirMonedas(double valor, String entrada, String salida) {
		String[] monedas = definirMonedas(entrada, salida);
		return ConversorDeMonedasApi.conversor(monedas, valor);
	}

}

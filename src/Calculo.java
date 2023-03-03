
public class Calculo {

	private static String[][] moneda = { { "USD-Dolar", "1", "1" }, { "CRC-Colon", "0.0018", "561.80" },
			{ "EUR-Euro", "1.06", "0.94" }, { "GBP-Libra", "1.2", "0.83" }, { "JPY-Yen", "0.0073", "136.35" },
			{ "KRW-Won surcoreano", "0.00076", "1311.57" } };
	private static String[][] distancia = { { "CM-Centimetro", "0.01", "100" }, { "M-metro", "1", "1" },
			{ "KM-Kilometro", "1000", "0.001" }, { "PUL-Pulgada", "0.0254", "39.3700930709" },
			{ "PIE-Pie", "0.3048", "3.2808410892" }, { "MI-Milla", "1852", "0.000539957" } };
	private static String[][] masa = { { "GR-Gramo", "0.001", "1000" }, { "KG-Kilogramo", "1", "1" },
			{ "TON-Tonelada", "907.185", "0.00110231" }, { "LIB-Libra", "0.453592", "2.20462" } };
	private static String[][] volumen = { { "ML-mililitro", "0.001", "1000" }, { "L-Litro", "1", "1" },
			{ "GAL-galon", "3.78541", "0.264172" }, { "OZ-Onza", "0.0295735", "33.814" } };

	// Determinamos el tipo de conversion (cinfirmando primero si el valor de
	// entrada es igual al de salida)
	public static double tipoDeConversion(double valor, String valorEntrada, String valorSalida) {
		if (valorEntrada == valorSalida) {
			return valor;
		} else {
			switch (Medidas.seleccion) {
			case "Moneda":
				return convertir(valor, valorEntrada, valorSalida, moneda);
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
	
	private static double temperatura(double valor, String entrada) {
		if (entrada=="C°-Celsius") {
			return 9.0 / 5.0 * valor + 32;
		}
		else {
			return (valor - 32) * 5.0 / 9.0;
		}
	}
}

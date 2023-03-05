
public class Verificacion {
	
	//METODO PARA VERIFICAR SI EL VALOR INGRESADO EN txtValor ES O NO NUMERICO
	public static boolean verificaEntero(String text) {
		try {
			@SuppressWarnings("unused")
			double valor = Double.parseDouble(text);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}

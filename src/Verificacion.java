
public class Verificacion {

	public static boolean verificaEntero(String text) {
	    double valor;
	    try {
	      valor=Double.parseDouble(text);
	      return true;
	    } catch (NumberFormatException ex) {
	       return false;
	    }
	}
	
}

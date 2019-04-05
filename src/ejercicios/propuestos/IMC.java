package ejercicios.propuestos;

/**
 * IMC
 */
public class IMC {
	private int altura;
	private int masa;
	public IMC(int n_altura, int n_masa) {
		altura = n_altura;
		masa = n_masa;
	}
	public float calcular() {
		return (float)(masa / Math.pow(altura/100.0,2.0));
	}

	public String getMensaje() {
		float imc = calcular();
		if (imc>=30.0) {
			return "Obesidad";
		} else if(imc>=25.0) {
			return "Peso superior al normal";
		} else if(imc>=18.5) {
			return "Normal";
		}  else if(imc>=0.0) {
			return "Peso inferior al normal";
		} else {
			return "Los datos ingresados son incorrectos";
		}
	}
}
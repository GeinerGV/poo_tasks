package fuerzas.rebeldes;

/**
 * TesterXWing
 */
public class TesterXWing {

	public static void main(String[] args) {
		XWing xw1 = new XWing();
		xw1.setId("XW-1");
		xw1.setRol_Space_starfighter(true);
		xw1.acelearar(0);
		xw1.acelearar(40);
		xw1.acelearar(5000);

		xw1.disparar_canon(true);
		xw1.disparar_misil();
		xw1.disparar_misil();
		xw1.disparar_misil();
		xw1.disparar_misil();
		xw1.disparar_misil();
		xw1.disparar_misil();
		xw1.acelearar(10);
		xw1.acelearar(3700);
		xw1.acelearar(-111000);
	}
}
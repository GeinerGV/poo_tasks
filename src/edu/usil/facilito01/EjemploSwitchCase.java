package edu.usil.facilito01;

public class EjemploSwitchCase {
	public static void main(String[] args) {
		EjemploSwitchCase objSC = new EjemploSwitchCase();
		objSC.logica();
	}

	public void logica() {
		int x = 5;
		switch (x) {
			case 1:
				System.out.println("Case 1");
				break;
			case 2:
				System.out.println("Case 2");
				break;
			case 5:
				System.out.println("Case 5");
				break;
			default:
				System.out.println("Default");
				break;
		}
	}
}
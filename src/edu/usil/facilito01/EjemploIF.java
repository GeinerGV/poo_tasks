package edu.usil.facilito01;

public class EjemploIF {
	public void logica() {
		int x = (int)(Math.random()*15.0);
		if (aprobar(x))	{
			System.out.println("Su NOTA es: "+ x);
			System.out.println("APRUEBA, muy bien!");
		} else {
			System.out.println("Su NOTA tiene oportunidades de mejora: "+x);
			System.out.println("Lamentablemente DESAPRUEBA :(");
		}
	}

	public boolean aprobar(int x) {
		boolean aprobar = false;
		if (x>=11) aprobar = true;
		return aprobar;
	}

	public static void main(String[] args) {
		EjemploIF objIf = new EjemploIF();
		objIf.logica();
	}
}
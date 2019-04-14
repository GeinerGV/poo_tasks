package fuerzas.imperiales;

/**
 * JediEspia
 */
public class JediEspia {

	public static void main(String[] args) {
		ClonTrooper ct1 = new ClonTrooper("SARGENTO", "ASALTO", "BLASTER XC-99");
		
		ct1.setRango("COMANDANTE");
		ct1.setEspecialidad("PILOTO");
		ct1.setArmamento("RIFLE SNIPPER");

		ct1.disparar();
	}
}
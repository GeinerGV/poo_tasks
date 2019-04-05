package star.wars.tester;

import fuerzas.imperiales.ClonTrooper;

public class ClonTrooperTester {
    public static void main(String[] args) {
        ClonTrooper ct1 = new ClonTrooper();
        ct1.setRango("SARGENTO");
        ct1.setEspecialidad("ASALTO");
        ct1.setArmamento("RIFLE DC-15");

        ClonTrooper ct2 = new ClonTrooper();
        ct2.setRango("COMANDANTE");
        ct2.setEspecialidad("ASALTO");
        ct2.setArmamento("BLASTER DC-15");

        ct1.disparar();
        ct1.disparar();

        ct2.disparar();
    }
}
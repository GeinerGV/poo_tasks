package star.wars.tester;

import fuerzas.imperiales.ClonTrooper;

public class ClonTrooperTester {
    public static void main(String[] args) {
        ClonTrooper ct1 = new ClonTrooper("SARGENTO", "ASALTO", "RIFLE DC-15");

        ClonTrooper ct2 = new ClonTrooper("COMANDANTE", "ASALTO", "BLASTER DC-15");

        ct1.disparar();
        ct1.disparar();

        ct2.disparar();
    }
}
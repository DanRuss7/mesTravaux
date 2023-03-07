import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vecteur v = new Vecteur();

        System.out.println("nbElements: " + v.getNbElements());
        System.out.println("capacite: " + v.getCapacite());
        System.out.println(v);

        v.insererALaFin("CS:GO");
        v.insererAuDebut("Apex Legends");
        v.insererALaFin("Diablo");
        v.insererAuMilieu("Borderlands", 1);
        System.out.println(v);

        v.insererALaFin("EarthBound");
        v.insererALaFin("Fallout");
        System.out.println(v);

        Vecteur v2 = v.copier();
        v2.insererAuMilieu("XCOM", 5);
        v2.afficher();
        System.out.println("Index XCOM: " + v2.rechercher("XCOM"));

        v2.supprimerAuMilieu(2);
        v2.supprimerALaFin();
        v2.supprimerAuDebut();
        System.out.println(v2);
    }
}

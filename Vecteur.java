public class Vecteur {
    final int TAILLE_INITIALE = 4;
    final int RATIO_AGRANDISSEMENT = 2;

    private String[] mTableau;
    private int mNbElements;
    private int mCapacite; // On pourrait aussi utiliser mTableau.length directement

    public Vecteur () {
        mTableau = new String[TAILLE_INITIALE];
        mNbElements = 0;
        mCapacite = TAILLE_INITIALE;
    }

    public void afficher() {
        for (int i = 0; i < mNbElements; i++)
            System.out.println("I" + i + ": " + mTableau[i]);
    }

    public void afficherReverse() {
        for (int i = mNbElements - 1; i >= 0; i--)
            System.out.println("I" + i + ": " + mTableau[i]);
    }

    public String getElement(int index) {
        return mTableau[index];
    }

    public int getNbElements() {
        return mNbElements;
    }

    public int getCapacite() {
        return mCapacite;
    }

    public int rechercher(String valeur) {
        for (int index = 0; index < mNbElements; index++) {
            if (mTableau[index] == valeur)
                return index;
        }
        return -1;
    }

    public Vecteur copier() {
        Vecteur v = new Vecteur();
        for (int i = 0; i < mNbElements; i++)
            v.insererALaFin(mTableau[i]);
        return v;
    }

    // Methodes d'insertion ===============================

    public int insererALaFin(String valeur) {
        if (mNbElements == mCapacite)
            agrandir();
        mTableau[mNbElements] = valeur;
        return ++mNbElements;
    }

    public int insererAuMilieu(String valeur, int index) {
        if (mNbElements == mCapacite)
            agrandir();

        for (int i = mNbElements; i > index; i--)
            mTableau[i] = mTableau[i - 1];

        mTableau[index] = valeur;
        return ++mNbElements;
    }

    public int insererAuDebut(String valeur) {
        return insererAuMilieu(valeur, 0);
    }

    private void agrandir() {
        mCapacite *= RATIO_AGRANDISSEMENT;
        String[] temp = new String[mCapacite];
        for (int i = 0; i < mNbElements; i++)
            temp[i] = mTableau[i];
        mTableau = temp;
    }

    // Methodes de suppression ============================

    public int supprimerALaFin() {
        if (mNbElements > 0)
            return --mNbElements;
        return -1;
    }

    public int supprimerAuMilieu(int index) {
        if (index < 0 || index >= mNbElements)
            return -1;

        for (int i = index; i < mNbElements - 1; i++)
            mTableau[i] = mTableau[i + 1];

        return --mNbElements;
    }

    public int supprimerAuDebut() {
        return supprimerAuMilieu(0);
    }

    public String toString() {
        String out = "";
        out += mNbElements + " elements (capacite ";
        out += mCapacite + "): ";
        for (int i = 0; i < mNbElements; i++)
            out += mTableau[i] + " ";
        for (int i = mNbElements; i < mCapacite; i++)
            out += "[" + mTableau[i] + "] ";
        return out;
    }
}

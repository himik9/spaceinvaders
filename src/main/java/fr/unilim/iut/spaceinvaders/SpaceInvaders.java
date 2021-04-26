package fr.unilim.iut.spaceinvaders;

public class SpaceInvaders {

  int longueur;
  int hauteur;
  Vaisseau vaisseau;

  public SpaceInvaders(int longueur, int hauteur) {
    this.longueur = longueur;
    this.hauteur = hauteur;
  }

  @Override
  public String toString() {
    StringBuilder espaceDeJeu = new StringBuilder();
    for (int y = 0; y < hauteur; y++) {
      for (int x = 0; x < longueur; x++) {
        char marque;
        if (this.aUnVaisseauQuiOccupeLaPosition(y, x))
          marque='V';
        else
          marque='.';

        espaceDeJeu.append(marque);
      }
      espaceDeJeu.append('\n');
    }
    return espaceDeJeu.toString();
  }

  private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
    return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
  }

  private boolean aUnVaisseau() {
    return vaisseau != null;
  }


  public void positionnerUnNouveauVaisseau(int x, int y) {
    this.vaisseau = new Vaisseau(x, y);

  }
}
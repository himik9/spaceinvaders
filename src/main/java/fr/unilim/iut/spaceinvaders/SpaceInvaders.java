package fr.unilim.iut.spaceinvaders;

import util.HorsEspaceJeuException;

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
    return recupererEspaceJeuDansChaineASCII();
  }

  public String recupererEspaceJeuDansChaineASCII() {
    StringBuilder espaceDeJeu = new StringBuilder();
    for (int y = 0; y < hauteur; y++) {
      for (int x = 0; x < longueur; x++) {
        espaceDeJeu.append(recupererMarqueDeLaPosition(y, x));
      }
      espaceDeJeu.append('\n');
    }
    return espaceDeJeu.toString();
  }

  private char recupererMarqueDeLaPosition(int y, int x) {
    char marque;
    char MARQUE_VAISSEAU = 'V';
    char MARQUE_VIDE = '.';
    if (this.aUnVaisseauQuiOccupeLaPosition(y, x))
      marque= MARQUE_VAISSEAU;
    else
      marque=MARQUE_VIDE;
    return marque;
  }

  private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
    return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
  }

  private boolean aUnVaisseau() {
    return vaisseau != null;
  }

  public void positionnerUnNouveauVaisseau(int x, int y) {

    if (!estDansEspaceDeJeu(x, y))
      throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");

    vaisseau = new Vaisseau(x, y);
  }

  private boolean estDansEspaceDeJeu(int x, int y) {
    return (((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur)));
  }

  public void deplacerVaisseauVersLaDroite() {
    if (vaisseau.getX()< (longueur-1)) vaisseau.seDeplacerVersLaDroite();  }

}
package fr.unilim.iut.spaceinvaders;


import org.junit.Test;
import util.HorsEspaceJeuException;

import static org.junit.Assert.assertEquals;

public class SpaceInvadersTest {


  @Test
  public void test_AuDebut_JeuSpaceInvaderEstVide() {
    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
    assertEquals("" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
  }

  @Test
  public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
    spaceinvaders.positionnerUnNouveauVaisseau(7,9);
    assertEquals("" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            "...............\n" +
            ".......V.......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII ());
  }

  @Test(expected = HorsEspaceJeuException.class)
  public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropADroite_UneExceptionEstLevee() throws Exception {
    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
    spaceinvaders.positionnerUnNouveauVaisseau(15,9);
  }

  @Test(expected = HorsEspaceJeuException.class)
  public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
    spaceinvaders.positionnerUnNouveauVaisseau(14,10);
  }

  @Test(expected = HorsEspaceJeuException.class)
  public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropAGauche_UneExceptionEstLevee() throws Exception {
    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
    spaceinvaders.positionnerUnNouveauVaisseau(15,11);
  }

  @Test(expected = HorsEspaceJeuException.class)
  public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnHaut_UneExceptionEstLevee() throws Exception {
    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
    spaceinvaders.positionnerUnNouveauVaisseau(16,10);
  }
}
package implementations;

import services.MineService;
import services.Side;
import services.TerrainType;

/**
 * Created by nizar on 07/05/15.
 */
public class MineImpl implements MineService {
    int abandonCompteur, largeur, hauteur, orRestant;
    boolean estAbandonnee, estLaminee;
    Side side;

    @Override
    public boolean estAbandonnee() {
        return this.estAbandonnee;
    }

    @Override
    public Integer abandonCompteur() {
        return this.abandonCompteur;
    }

    @Override
    public Side side() {
        return this.side;
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer orRestant, Side side) {

    }

    public void init(Integer largeur, Integer hauteur, Integer orRestant, Side side, TerrainType type) {


    }

    @Override
    public void acceuil(Side side) {

    }

    @Override
    public void abandoned() {

    }

    @Override
    public Integer largeur() {
        return null;
    }

    @Override
    public Integer hauteur() {
        return null;
    }

    @Override
    public TerrainType type() {
        return null;
    }

    @Override
    public Integer orRestant() {
        return null;
    }

    @Override
    public boolean estLaminee() {
        return false;
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer orRestant, TerrainType type) {

    }

    @Override
    public void retrait(Integer somme) {

    }
//tu code si ta pas compris
}

package implementations;

import services.MineService;
import services.Side;
import services.TerrainType;

/**
 * Created by nizar on 07/05/15.
 */
public class MineImpl extends TerrainImpl implements MineService {
    int abandonCompteur;
    boolean estAbandonnee;
    Side side;

    public MineImpl() {
        super();
        this.side = Side.NONE;
        super.t = TerrainType.MINE;
        this.abandonCompteur = 51;
    }

    public MineImpl(int largeur, int hauteur, int orRestant) {
        this.init(largeur, hauteur, orRestant, Side.NONE);
    }

    @Override
    public boolean estAbandonnee() {
        if (this.abandonCompteur() == 51) {
            this.estAbandonnee = true;
            return this.estAbandonnee;
        } else {
            this.estAbandonnee = false;
            return this.estAbandonnee;
        }
    }

    @Override
    public Integer abandonCompteur() {
        return this.abandonCompteur;
    }

    @Override
    public Side side() {
        if (estAbandonnee()) {
            return Side.NONE;
        } else {
            return this.side;
        }
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer orRestant, Side side) {

        super.init(largeur, hauteur, orRestant, TerrainType.MINE);
        this.side = side;
        super.t = TerrainType.MINE;
        this.abandonCompteur = 51;
    }


    @Override
    public void acceuil(Side side) {
        this.abandonCompteur = 0;

    }

    @Override
    public void abandoned() {
        this.abandonCompteur++;
    }

    @Override
    public boolean getIsAbandoned() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getIsAccueil() {
        // TODO Auto-generated method stub
        return false;
    }


}

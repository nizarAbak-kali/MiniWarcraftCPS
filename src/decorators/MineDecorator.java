package decorators;

import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.MineService;
import services.Side;
import services.TerrainType;

public class MineDecorator implements MineService {
    protected MineService delegate;

    @Override
    public Integer largeur() {
        return delegate.largeur();
    }

    @Override
    public Integer hauteur() {
        return delegate.hauteur();
    }

    @Override
    public TerrainType type() {
        return delegate.type();
    }

    @Override
    public Integer orRestant() {
        return delegate.orRestant();
    }

    @Override
    public boolean estLaminee() {
        return delegate.estLaminee();
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer orRestant, TerrainType type) throws PreConditionException, PostConditionException {
        delegate.init(largeur, hauteur, orRestant, type);
    }

    @Override
    public void retrait(Integer somme) throws PreConditionException, PostConditionException {
        delegate.retrait(somme);
    }

    @Override
    public boolean estAbandonnee() {
        return delegate.estAbandonnee();
    }

    @Override
    public Integer abandonCompteur() {
        return delegate.abandonCompteur();
    }

    @Override
    public Side side() throws PreConditionException {
        return delegate.side();
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer orRestant,
                     Side side) throws PreConditionException, PostConditionException {
        delegate.init(largeur, hauteur, orRestant, side);
    }

    @Override
    public void acceuil(Side side) throws PreConditionException, PostConditionException {
        delegate.acceuil(side);
    }

    @Override
    public void abandoned() throws PreConditionException, PostConditionException {
        delegate.abandoned();
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

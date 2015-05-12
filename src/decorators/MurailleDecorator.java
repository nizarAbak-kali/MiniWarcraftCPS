package decorators;

import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.MurailleService;
import services.TerrainType;

public class MurailleDecorator implements MurailleService {
    protected MurailleService delegate;

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
    public void init(Integer largeur, Integer hauteur, Integer orRestant,
                     TerrainType type) throws PreConditionException, PostConditionException {
        delegate.init(largeur, hauteur, orRestant, type);
    }

    @Override
    public void retrait(Integer somme) throws PreConditionException, PostConditionException {
        delegate.retrait(somme);
    }

    @Override
    public Integer pointsRes() {
        return delegate.pointsRes();
    }

    @Override
    public boolean estDetruite() {
        return delegate.estDetruite();
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer pointRes) throws PreConditionException, PostConditionException {
        delegate.init(largeur, hauteur, pointRes);
    }

    @Override
    public void estfrappee(Integer force) throws PreConditionException, PostConditionException {
        delegate.estfrappee(force);
    }
}

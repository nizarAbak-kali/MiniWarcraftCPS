package decorators;

import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.RouteService;
import services.TerrainType;

public class RouteDecorator implements RouteService {
    protected RouteService delegate;

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
    public double facteurMult() {
        return delegate.facteurMult();
    }

    @Override
    public void init(Integer largeur, Integer hauteur, double facteur) throws PreConditionException, PostConditionException {
        delegate.init(largeur, hauteur, facteur);
    }


}

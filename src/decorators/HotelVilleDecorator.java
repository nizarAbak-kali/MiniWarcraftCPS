package decorators;

import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.HotelVilleService;
import services.Side;
import services.TerrainType;

public class HotelVilleDecorator implements HotelVilleService{
	protected HotelVilleService delegate;
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
	public void init(Integer largeur, Integer hauteur, Integer orRestant,TerrainType type) throws PreConditionException, PostConditionException {
		delegate.init(largeur, hauteur, orRestant, type);
	}

	@Override
	public void retrait(Integer somme) throws PreConditionException, PostConditionException {
		delegate.retrait(somme);
	}

	@Override
	public Side side() {
		return delegate.side();
	}

	@Override
	public void init(Integer largeur, Integer hauteur, Side side, Integer orRestant) throws PreConditionException, PostConditionException {
		delegate.init(largeur, hauteur, side, orRestant);
	}

	@Override
	public void depot(Integer somme) throws PreConditionException, PostConditionException {
		delegate.depot(somme);
	}

}

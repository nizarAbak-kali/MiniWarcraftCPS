package decorators;

import services.MurailleService;
import services.TerrainType;

public class MurailleDecorator implements MurailleService{
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
			TerrainType type) {
		delegate.init(largeur, hauteur, orRestant, type);
	}

	@Override
	public void retrait(Integer somme) {
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
	public void init(Integer largeur, Integer hauteur, Integer pointRes) {
		delegate.init(largeur, hauteur, pointRes);
	}

	@Override
	public void estfrappee(Integer force) {
		delegate.estfrappee(force);
	}
}

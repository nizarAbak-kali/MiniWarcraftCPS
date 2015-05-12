package decorators;

import services.TerrainService;
import services.TerrainType;

public class TerrainDecorator implements TerrainService{
	protected TerrainService delegate;

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

}

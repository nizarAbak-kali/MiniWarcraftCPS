package decorators;
/*
ABAK-KALI Nizar
BAYASSI Majd
*/
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.IVillageoisService;

public class VillageoisDecorator implements IVillageoisService{
	protected IVillageoisService delegate;
	@Override
	public Race race() {
		return delegate.race();
	}

	@Override
	public Side side() {
		return delegate.side();
	}

	@Override
	public int largeur() {
		return delegate.largeur();
	}

	@Override
	public int hauteur() {
		return delegate.hauteur();
	}

	@Override
	public int force() {
		return delegate.force();
	}

	@Override
	public double vitesse() {
		return delegate.vitesse();
	}

	@Override
	public int pointsDeVie() {
		return delegate.pointsDeVie();
	}

	@Override
	public int quantiteOr() {
		return delegate.quantiteOr();
	}

	@Override
	public boolean estMort() {
		return delegate.estMort();
	}

	@Override
	public void init(Race r, Side s, int l, int h, int f, double v, int p) throws PreConditionException, InvariantError, PostConditionException {
		delegate.init(r, s, l, h, f, v, p);
	}

	@Override
	public void retrait(int s) throws InvariantError, PreConditionException, PostConditionException {
		delegate.retrait(s);
	}

	@Override
	public void viderPoches() throws InvariantError, PostConditionException {
		delegate.viderPoches();
	}

	@Override
	public void recupere(int s) throws InvariantError, PreConditionException, PostConditionException {
		delegate.recupere(s);
	}

}

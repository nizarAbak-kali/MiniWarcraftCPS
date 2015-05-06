package implementations;
/*
ABAK-KALI Nizar
BAYASSI Majd
*/

import services.VillageoisService;

public class Villageois implements VillageoisService {
    private Race r;
    private Side s;
	private int l,h,f,pdv,or;
	private double v;
	private boolean estMort;

	@Override
	public Race race() {
		return r;
	}

	@Override
	public Side side() {
		return s;
	}

	@Override
	public int largeur() {
		return l;
	}

	@Override
	public int hauteur() {
		return h;
	}

	@Override
	public int force() {
		return f;
	}

	@Override
	public double vitesse() {
		return v;
	}

	@Override
	public int pointsDeVie() {
		return pdv;
	}

	@Override
	public int quantiteOr() {
		return or;
	}

	@Override
	public boolean estMort() {
		if(pointsDeVie()<=0)
			return true;
		return false;
	}

	@Override
	public void init(Race r, Side s, int l, int h, int f, double v, int p) {
		this.r = r;
		this.s = s;
		this.l = l;
		this.h = h;
		this.f = f;
		this.v = v;
		pdv = p;
		or = 0;
	}

	@Override
	public void retrait(int s) {
		pdv -= s;
	}

	@Override
	public void viderPoches() {
		or = 0;
	}

	@Override
	public void recupere(int s) {
		or += s;
	}
}

package decorators;

import java.util.Set;

import services.Commande;
import services.HotelVilleService;
import services.MineService;
import services.MoteurJeuService;
import services.MurailleService;
import services.Race;
import services.Resultat;
import services.RouteService;
import services.Side;
import services.VillageoisService;

public class MoteurJeuDecorator implements MoteurJeuService{
	
	protected MoteurJeuService delegate;
	
	@Override
	public Integer largeurTerrain() {
		return delegate.largeurTerrain();
	}

	@Override
	public Integer hauteurTerrain() {
		return delegate. hauteurTerrain();
	}

	@Override
	public Integer maxPasJeu() {
		return delegate.maxPasJeu();
	}

	@Override
	public Integer pasJeuCourant() {
		return delegate.pasJeuCourant();
	}

	@Override
	public Race playerRace() {
		return delegate.playerRace();
	}

	@Override
	public Race enemyRace() {
		return delegate.enemyRace();
	}

	@Override
	public boolean estFini() {
		return delegate.estFini();
	}

	@Override
	public Resultat resultatFinal() {
		return delegate.resultatFinal();
	}

	@Override
	public Set<Integer> numerosVillageois() {
		return delegate.numerosVillageois();
	}

	@Override
	public VillageoisService getVillageois(Integer num) {
		return delegate.getVillageois(num);
	}

	@Override
	public Integer positionVillageoisX(Integer num) {
		return delegate.positionVillageoisX(num);
	}

	@Override
	public Integer positionVillageoisY(Integer num) {
		return delegate.positionVillageoisY(num);
	}

	@Override
	public Set<Integer> numerosMine() {
		return delegate.numerosMine();
	}

	@Override
	public MineService getMine(Integer num) {
		return delegate.getMine(num);
	}

	@Override
	public Integer positionMineX(Integer num) {
		return delegate.positionMineX(num);
	}

	@Override
	public Integer positionMineY(Integer num) {
		return delegate.positionMineY(num);
	}

	@Override
	public Set<Integer> numerosRoute() {
		return delegate.numerosRoute();
	}

	@Override
	public RouteService getRoute(Integer num) {
		return delegate.getRoute(num);
	}

	@Override
	public Integer positionRouteX(Integer num) {
		return delegate.positionRouteX(num);
	}

	@Override
	public Integer positionRouteY(Integer num) {
		return delegate.positionRouteY(num);
	}

	@Override
	public Set<Integer> numerosMuraille() {
		return delegate.numerosMuraille();
	}

	@Override
	public MurailleService getMuraille(Integer num) {
		return delegate.getMuraille(num);
	}

	@Override
	public Integer positionMurailleX(Integer num) {
		return delegate.positionMurailleX(num);
	}

	@Override
	public Integer positionMurailleY(Integer num) {
		return delegate.positionMurailleY(num);
	}

	@Override
	public HotelVilleService hotelDeVille(Side side) {
		return delegate.hotelDeVille(side);
	}

	@Override
	public Integer positionHotelVilleX(Side side) {
		return delegate.positionHotelVilleX(side);
	}

	@Override
	public Integer positionHotelVilleY(Side side) {
		return delegate.positionHotelVilleY(side);
	}

	@Override
	public boolean peutEntrer(Integer numVillageois, Integer numMine) {
		return delegate.peutEntrer(numVillageois, numMine);
	}

	@Override
	public boolean peutEntrerHotelVille(Integer numVillageois, Side side) {
		return delegate.peutEntrerHotelVille(numVillageois, side);
	}

	@Override
	public void init(Integer largeur, Integer hauteur, Integer maxpas, Race r1,Race r2) {
		delegate.init(largeur, hauteur, maxpas, r1, r2);
	}

	@Override
	public void pasJeu(Commande com, Integer villageois, Integer arg) {
		delegate.pasJeu(com, villageois, arg);
	}

}

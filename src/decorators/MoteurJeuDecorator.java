package decorators;

import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.*;

import java.util.Set;

public class MoteurJeuDecorator implements MoteurJeuService {

    protected MoteurJeuService delegate;

    @Override
    public Integer largeurTerrain() {
        return delegate.largeurTerrain();
    }

    @Override
    public Integer hauteurTerrain() {
        return delegate.hauteurTerrain();
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
    public Resultat resultatFinal() throws PreConditionException {
        return delegate.resultatFinal();
    }

    @Override
    public Set<Integer> numerosVillageois() {
        return delegate.numerosVillageois();
    }

    @Override
    public VillageoisService getVillageois(Integer num) throws PreConditionException {
        return delegate.getVillageois(num);
    }

    @Override
    public Integer positionVillageoisX(Integer num) throws PreConditionException {
        return delegate.positionVillageoisX(num);
    }

    @Override
    public Integer positionVillageoisY(Integer num) throws PreConditionException {
        return delegate.positionVillageoisY(num);
    }

    @Override
    public Set<Integer> numerosMine() {
        return delegate.numerosMine();
    }

    @Override
    public MineService getMine(Integer num) throws PreConditionException {
        return delegate.getMine(num);
    }

    @Override
    public Integer positionMineX(Integer num) throws PreConditionException {
        return delegate.positionMineX(num);
    }

    @Override
    public Integer positionMineY(Integer num) throws PreConditionException {
        return delegate.positionMineY(num);
    }

    @Override
    public Set<Integer> numerosRoute() {
        return delegate.numerosRoute();
    }

    @Override
    public RouteService getRoute(Integer num) throws PreConditionException {
        return delegate.getRoute(num);
    }

    @Override
    public Integer positionRouteX(Integer num) throws PreConditionException {
        return delegate.positionRouteX(num);
    }

    @Override
    public Integer positionRouteY(Integer num) throws PreConditionException {
        return delegate.positionRouteY(num);
    }

    @Override
    public Set<Integer> numerosMuraille() {
        return delegate.numerosMuraille();
    }

    @Override
    public MurailleService getMuraille(Integer num) throws PreConditionException {
        return delegate.getMuraille(num);
    }

    @Override
    public Integer positionMurailleX(Integer num) throws PreConditionException {
        return delegate.positionMurailleX(num);
    }

    @Override
    public Integer positionMurailleY(Integer num) throws PreConditionException {
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
    public boolean peutEntrer(Integer numVillageois, Integer numMine) throws PreConditionException {
        return delegate.peutEntrer(numVillageois, numMine);
    }

    @Override
    public boolean peutEntrerHotelVille(Integer numVillageois, Side side) throws PreConditionException {
        return delegate.peutEntrerHotelVille(numVillageois, side);
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer maxpas, Race r1, Race r2) throws PreConditionException, PostConditionException {
        delegate.init(largeur, hauteur, maxpas, r1, r2);
    }

    @Override
    public void pasJeu(Commande com, Integer villageois, Integer arg) throws PreConditionException, PostConditionException {
        delegate.pasJeu(com, villageois, arg);
    }

}

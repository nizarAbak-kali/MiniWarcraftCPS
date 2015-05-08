package implementations;

import services.*;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by nizar on 08/05/15.
 */
public class MoteurJeuImpl extends TerrainImpl implements MoteurJeuService {
    int largeurT, hauteurT, maxPasJ, pasJeuC;
    Race prace, enrace;

    HotelVillePosition playerHotelDeVille = null;
    HotelVillePosition ennemyHotelDeVille = null;


    HashMap<Integer, VillageoisPosition> liste_villageois = new HashMap<>();
    HashMap<Integer, MinePosition> liste_mines = new HashMap<>();
    HashMap<Integer, RoutePosition> liste_routes = new HashMap<>();
    HashMap<Integer, MuraillePosition> liste_murailles = new HashMap<>();


    @Override
    public Integer largeurTerrain() {
        return this.largeurT;
    }

    @Override
    public Integer hauteurTerrain() {
        return this.hauteurT;
    }

    @Override
    public Integer maxPasJeu() {
        return this.maxPasJ;
    }

    @Override
    public Integer pasJeuCourant() {
        return this.pasJeuC;
    }

    @Override
    public Race playerRace() {
        return this.prace;
    }

    @Override
    public Race enemyRace() {
        return this.enrace;
    }

    @Override
    public boolean estFini() {
        if (this.pasJeuCourant() == this.maxPasJeu()
                || this.hotelDeVille(Side.PLAYER).orRestant() >= 1664
                || this.hotelDeVille(Side.ENEMY).orRestant() >= 1664)
            return true;
        else {
            return false;
        }

    }

    @Override
    public Resultat resultatFinal() {
        if (hotelDeVille(Side.PLAYER).orRestant() >= 1664 &&
                hotelDeVille(Side.ENEMY).orRestant() < 1664) {
            return Resultat.GAGNE;
        }
        if (hotelDeVille(Side.ENEMY).orRestant() >= 1664 &&
                hotelDeVille(Side.PLAYER).orRestant() < 1664) {
            return Resultat.PERDU;
        }
        return Resultat.EGALITE;
    }

    @Override
    public Set<Integer> numerosVillageois() {
        return this.liste_villageois.keySet();
    }

    @Override
    public VillageoisService getVillageois(Integer num) {
        VillageoisPosition v = liste_villageois.get(num);
        return v.getVillageois();
    }

    @Override
    public Integer positionVillageoisX(Integer num) {
        VillageoisPosition v = liste_villageois.get(num);
        return v.getX();
    }

    @Override
    public Integer positionVillageoisY(Integer num) {
        VillageoisPosition v = liste_villageois.get(num);
        return v.getY();
    }

    @Override
    public Set<Integer> numerosMine() {
        return liste_mines.keySet();
    }

    @Override
    public MineService getMine(Integer num) {
        MinePosition m = liste_mines.get(num);
        return m.getMine();
    }

    @Override
    public Integer positionMineX(Integer num) {
        MinePosition m = liste_mines.get(num);
        return m.getX();
    }

    @Override
    public Integer positionMineY(Integer num) {
        MinePosition m = liste_mines.get(num);
        return m.getY();
    }

    @Override
    public Set<Integer> numerosRoute() {
        return liste_routes.keySet();
    }

    @Override
    public RouteService getRoute(Integer num) {
        RoutePosition r = liste_routes.get(num);
        return r.getRoute();
    }

    @Override
    public Integer positionRouteX(Integer num) {
        RoutePosition r = liste_routes.get(num);
        return r.getX();
    }

    @Override
    public Integer positionRouteY(Integer num) {
        RoutePosition r = liste_routes.get(num);
        return r.getY();
    }

    @Override
    public Set<Integer> numerosMuraille() {
        return liste_murailles.keySet();
    }

    @Override
    public MurailleService getMuraille(Integer num) {
        MuraillePosition m = liste_murailles.get(num);
        return m.getMuraille();
    }

    @Override
    public Integer positionMurailleX(Integer num) {
        MuraillePosition m = liste_murailles.get(num);
        return m.getX();
    }

    @Override
    public Integer positionMurailleY(Integer num) {
        MuraillePosition m = liste_murailles.get(num);
        return m.getY();
    }

    @Override
    public HotelVilleService hotelDeVille(Side side) {
        if (side.equals(Side.PLAYER)) {
            return playerHotelDeVille.getHotelVille();
        } else {
            return ennemyHotelDeVille.getHotelVille();
        }
    }

    @Override
    public Integer positionHotelVilleX(Side side) {
        if (side.equals(Side.PLAYER)) {
            return playerHotelDeVille.getX();
        } else {
            return ennemyHotelDeVille.getX();
        }
    }

    @Override
    public Integer positionHotelVilleY(Side side) {
        if (side.equals(Side.PLAYER)) {
            return playerHotelDeVille.getY();
        } else {
            return ennemyHotelDeVille.getY();
        }
    }

    @Override
    public boolean peutEntrer(Integer numVillageois, Integer numMine) {
        return true;
    }

    @Override
    public boolean peutEntrerHotelVille(Integer numVillageois, Side side) {
        return false;
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer maxpas, Race r1, Race r2) {

    }

    @Override
    public void pasJeu(Commande com, Integer villageois, Integer arg) {

    }
}

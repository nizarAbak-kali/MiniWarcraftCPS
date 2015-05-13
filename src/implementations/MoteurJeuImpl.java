package implementations;

import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;
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
    public boolean peutEntrer(Integer numV, Integer numM) {
        PositionFonction p = new PositionFonction();
        if (p.distance(positionVillageoisX(numV), positionVillageoisY(numV), positionMineX(numM), positionMineY(numM))
                <= 51) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean peutEntrerHotelVille(Integer numVillageois, Side side) {
        return false;
    }

    public int surRoute(Integer numV) {
        PositionFonction p = new PositionFonction();

        for (Integer i : numerosRoute()) {
            if (p.collision(positionVillageoisX(numV), positionVillageoisY(numV),
                    positionRouteX(i), positionRouteY(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer maxpas, Race r1, Race r2) {
        super.init(largeur, hauteur, 0, TerrainType.NONE);
        this.maxPasJ = maxpas;
        this.prace = r1;
        this.enrace = r2;

    }

    @Override
    public void pasJeu(Commande com, Integer villageois, Integer arg) throws PreConditionException, PostConditionException, InvariantError {
        pasJeuC++;
        VillageoisPosition vp = liste_villageois.get(villageois);
        for (Integer i : numerosMine()) {
            MineService m = getMine(i);
            if (!m.estAbandonnee()) {
                m.abandoned();
            }
        }
        switch (com) {
            case RIEN:
                break;
            case DEPLACER:
                double f = 1;
                double angle = Math.toRadians(arg);

                int i = surRoute(villageois);
                if (i != -1) {
                    f = getRoute(i).facteurMult();
                }
                int newX = (int) (vp.getVillageois().vitesse() * f * Math.cos(angle)) + positionVillageoisX(villageois);
                int newY = (int) (vp.getVillageois().vitesse() * f * Math.sin(angle)) + positionVillageoisY(villageois);
                vp.setX(newX);
                vp.setY(newY);
                break;
            case ENTRERMINE:
                MineService mineToEnter = getMine(arg);
                if (mineToEnter != null) {
                    if (peutEntrer(villageois, arg)) {
                        int retire = 10;
                        mineToEnter.acceuil(vp.getVillageois().side());

                        if (!mineToEnter.estLaminee()) {
                            int recupere;
                            if (mineToEnter.orRestant() < retire) {
                                recupere = mineToEnter.orRestant();
                            } else {
                                recupere = retire;
                            }
                            mineToEnter.retrait(recupere);
                            vp.getVillageois().recupere(recupere);
                        }
                    }
                }
                break;
            case ENTRERHOTELVILLE:
                Side side = getVillageois(villageois).side();
                if (peutEntrerHotelVille(villageois, getVillageois(villageois).side())) {
                    hotelDeVille(side).depot(getVillageois(villageois).quantiteOr());
                    getVillageois(villageois).viderPoches();
                }
                break;
            case FRAPPEMURAILLE:
                MurailleService murailleToHit = getMuraille(arg);
                if (murailleToHit != null) {
                    murailleToHit.estfrappee(getVillageois(villageois).force());
                }
                break;
        }
    }

}

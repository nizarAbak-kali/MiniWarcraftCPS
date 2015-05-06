package services;

import java.util.Set;

/**
 * Created by nizar on 06/05/15.
 */
public interface MoteurJeuService {

    /* Observartors */
    public Integer largeurTerrain();

    public Integer hauteurTerrain();

    public Integer maxPasJeu();

    public Integer pasJeuCourant();

    public Race playerRace();

    public Race enemyRace();

    public boolean estFini();

    /*
    * pre resultatFinal(M) require estFini(M)
    * */
    public Resultat resultatFinal();

    public Set<Integer> numerosVillageois();

    /*
    * pre getVillageois(M,num) require num ∈ numerosVillageois(M,num)
    * */
    public VillageoisService getVillageois(Integer num);

    //pre positionVillageoisX(M,num) require num ∈ numerosVillageois(M,num)
    public Integer positionVillageoisX(Integer num);

    //pre positionVillageoisY(M,num) require num ∈ numerosVillageois(M,num)
    public Integer positionVillageoisY(Integer num);

    public Set<Integer> numerosMine();

    //pre getMine(M,num) require num ∈ numerosMine(M,num)
    public MineService getMine(Integer num);

    //pre positionMineX(M,num) require num ∈ numerosMine(M,num)
    public Integer positionMineX(Integer num);

    //pre positionMineY(M,num) require num ∈ numerosMine(M,num)
    public Integer positionMineY(Integer num);


    public Set<Integer> numerosRoute();

    //  pre getRoute(M,num) require num ∈ numerosRoute(M,num)
    public RouteService getRoute(Integer num);

    //pre positionRouteX(M,num) require num ∈ numerosRoute(M,num)
    public Integer positionRouteX(Integer num);

    // pre positionRouteY(M,num) require num ∈ numerosRoute(M,num)
    public Integer positionRouteY(Integer num);

    public Set<Integer> numerosMuraille();

    //pre getMuraille(M,num) require num ∈ numerosMuraille(M,num)
    public MurailleService getMuraille(Integer num);

    //pre positionMurailleX(M,num) require num ∈ numerosMuraille(M,num)
    public Integer positionMurailleX(Integer num);

    //pre positionMurailleY(M,num) require num ∈ numerosMuraille(M,num)
    public Integer positionMurailleY(Integer num);

    public HotelVilleService hotelDeVille(Side side);

    public Integer positionHotelVilleX(Side side);

    public Integer positionHotelVilleY(Side side);

    /*
    *  pre peutEntrer(M,numVillageois,numMine)
    *  require numVillageois ∈ numeroesVillageois(M,numVillageois)
        ∧ numMine ∈ numeroesMine(M,numMine)
    * */
    public boolean peutEntrer(Integer numVillageois, Integer numMine);

    /*
    * pre peutEntrerHotelVille(M,numVillageois, s)
    * require numVillageois ∈ numeroesVillageois(M,numVillageois)
    * */
    public boolean peutEntrerHotelVille(Integer numVillageois, Side side);

    /* Constructors */
    /*
    * pre init(largeur,hauteur,maxPas, r1, r2) require largeur≥ 600 ∧
     * hauteur≥ 400 ∧ maxPas≥ 0
    */
    public void init(Integer largeur, Integer hauteur, Integer maxpas, Race r1, Race r2);


    /* Opertators */
    /*
    *
    * pre pasJeu(M, comm, vill, arg) require vill ∈ numeroesVillageois(M) ∧ ¬estFini(M) ∧
    {
        comm = DEPLACER ⇒ 0 ≤ arg < 360
        comm = ENTRERMINE ⇒ arg ∈ numeroesMine(M) ∧ peutEntrer(M, vill, arg)
        comm = ENTRERHOTELVILLE ⇒ peutEntrerHotelVille(M, vill)
    }
 */
    public void pasJeu(Commande com, Integer villageois, Integer arg);

     /*

    Observations :


   [invariants]
    0 ≤ pasJeuCourant(M) ≤ maxPasJeu(M)

    estFini(M) =(min) HotelVille::orRestant(hotelDeVille(M,PLAYER)) ≥ 1664 ∨ HotelVille::orRestant(hotelDeVille(M, ENEMY)) ≥ 1664 ∨ pasJeuCourant(M)=maxPasJeu(M))

    resultatFinal(M)=GAGNE ⇔ HotelVille::orRestant(hotelDeVille(M, PLAYER)) ≥ 1664 ∧ HotelVille::orRestant(hotelDeVille(M, ENEMY)) < 1664
    resultatFinal(M)=PERDU ⇔ HotelVille::orRestant(hotelDeVille(M, ENEMY)) ≥ 1664 ∧ HotelVille::orRestant(hotelDeVille(M, PLAYER)) < 1664
    resultatFinal(M)=EGALITE ⇔ resultatFinal(M) != PERDU ∧ resultatFinal(M) != GAGNE
                                                                             peutEntrer(M,numVillageois,numMine) =(min) distance(positionVillageoisX(M,numVillageois),positionVillageoisY(M,numVillageois),
    positionMineX(M,numMine),positionMineY(M,numMine)) ≤ 51
    peutEntrerHotelVille(M,numVillageois) =(min) distance(positionVillageoisX(M,numVillageois),positionVillageoisY(M,numVillageois), positionHotelVilleX(M, Villageois::side(getVillageois(numVillageois))),positionHotelVilleY(M, Villageois::side(getVillageois(numVillageois)))) ≤ 51 ∧ Villageois::side(getVillageois(numVillageois))

    [init]
    largeurTerrain(init(l,h,m, r1, r2)) = l
    hauteurTerrain(init(l,h,m, r1, r2)) = h
    maxPasJeu(init(l,h,m, r1, r2))=m
    pasJeuCourant(init(l,h,m, r1, r2))=0
    resultatFinal(init(l,h,m, r1, r2))=EGALITE
    playerRace(init(l,h,m, r1, r2)) = r1
                                                                         enemyRace(init(l,h,m, r1, r2)) = r2
    //Les autres observateurs sont initialisées à partir d'un fichier de configuration
    //On s'assurera tout de même que les deux hotel de ville sont initialisés et qu'il y'ait tout de même
    //un nombre de villageois au moins égal à 3, et un nombre de mine au moins égal à 3 aussi
    [pasJeu]
    pasJeuCourant(pasJeu(M,c,numVillageois,arg))=pasJeuCourant(M) +1
    {
        c = ENTRERMINE ⇒ ∀ i ∈ numeroesMine(M) / arg , ¬Mine::estAbandonnee(getMine(M, i)) ⇒ Mine::abandoned(getMine(M, i))
        c != ENTRERMINE ⇒ ∀ i ∈ numeroesMine(M) , ¬Mine::estAbandonnee(getMine(M, i)) ⇒ Mine::abandoned(getMine(M, i))
    }
*/
}

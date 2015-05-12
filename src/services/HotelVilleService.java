package services; 

/**
 * Created by nizar on 05/05/15.
 */
public interface HotelVilleService extends TerrainService {

    /*Observators */
    public Side side();


    /* Constructors */
     /*
        init : int × int × Side × int → [HotelVille]
        pre: init(largeur,hauteur,side,orRestant) require largeur%2=1 ∧ hauteur%2=1 ∧ orRestant>0 ∧ side!=NONE
        post side(init(l,h,s,o)) = s
     */
    public void init(Integer largeur, Integer hauteur, Side side, Integer orRestant);


    /* Operators */
    /*
        depot : [HotelVille] × int → [HotelVille]
        pre: depot(H,somme) require somme>0
    */
    public void depot(Integer somme);

    /* Observations */

    /*
    [invariants]
	estLaminee(M) = orRestant(M) ≤ 0
	
    [init]
    Terrain::largeur(init(l,h,s,o)) = l
    Terrain::hauteur(init(l,h,s,o)) = h
    Terrain::type(init(l,h,s,o)) = HOTELVILLE
    Terrain::orRestant(init(l,h,s,o)) = 51
    side(init(l,h,s,o)) = s

    [depot]
    Terrain::orRestant(depot(H,somme)) = orRestant(H)+somme
      */

}

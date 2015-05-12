package services;

/**
 * Created by nizar on 06/05/15.
 */
public interface MineService extends TerrainService {
    /* Observators */
    public boolean estAbandonnee();

    public Integer abandonCompteur();

    // pre side(M) require ¬estAbandonnee(M)
    public Side side();

    /* Constructors */
    /* init : int × int × int x SIDE -> [Mine]
       pre init(largeur,hauteur,orRestant,side) require largeur%2=1 ∧ hauteur%2=1 ∧ orRestant>0 ∧ side != null

    */
    public void init(Integer largeur, Integer hauteur, Integer orRestant, Side side);

    /* Operators */
    /*
    pre  acceuil(M,side) require ¬abandoned(M) ∧ side != NONE
    */
    public void acceuil(Side side);


    /*
    pre abandoned(M) require ¬acceuil(M)
    */
    public void abandoned();



   /* Observations */

    /*
   [Invariants]
    estAbandonnee(M) =(min) abandonCompteur = 51
    0 ≤abandonCompteur(M) ≤ 51
    side(M) = NONE ⇔ estAbandonnee(M)
    Terrain::estLaminee(M) =(min) orRestant(M)<= 0

    [init]
    Terrain::largeur(init(l,h,o)) = l
    Terrain::hauteur(init(l,h,o)) = h
    Terrain::type(init(l,h,o)) = MINE
    Terrain::orRestant(init(l,h,o)) = 51
    abandonCompteur(init(l,h,o)) = 51
    side(init(l,h,o)) = NONE

    [acceuil]
    Terrain::orRestant(acceuil(M)) = orRestant(M)
    abandonCompteur(accueil(M)) = 0
    side(acceuil(M, s)) = s

    [abandoned]
    Terrain::orRestant(abandoned(M)) = orRestant(M)
    abandonCompteur(abandoned(M)) = abandonCompteur()+1
    side(abandoned(M)) = side(M)

    [retrait]
    abandonCompteur(retrait(S,somme)) = abandonCompteur(S)
    side(Terrain::retrait(M, s)) = side(M)

       */
}

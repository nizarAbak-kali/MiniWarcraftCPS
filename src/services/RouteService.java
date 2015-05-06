package services;

/**
 * Created by nizar on 06/05/15.
 */
public interface RouteService extends TerrainService {
    /* Observators */
    public Integer facteurMult();

    /* Constructors */
    /*
    pre init(largeur,hauteur,facteur) require largeur%2=1 ∧ hauteur%2=1 ∧ 0<facteur≤10
     */
    public void init(Integer largeur, Integer hauteur, Integer facteur);

    /* Observations */
    /*
    [init]
    Terrain::largeur(init(l,h,f))=l
    Terrain::hauteur(init(l,h,f))=h
    facteurMult(init(l,h,f)) = f
    Terrain::type(init(l,h))=ROUTE
    * */

}

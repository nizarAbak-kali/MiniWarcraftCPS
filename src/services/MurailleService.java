package services;

import exceptions.PostConditionException;
import exceptions.PreConditionException;

/**
 * Created by nizar on 06/05/15.
 */
public interface MurailleService extends TerrainService {


    /* observators */
    public Integer pointsRes();

    public boolean estDetruite();

    /* Constructors */
    /*
    *  pre init(largeur,hauteur, pointsRes)
    *  require largeur%2=1 ∧ hauteur%2=1 ∧ pointsRes>0
    * */
    public void init(Integer largeur, Integer hauteur, Integer pointRes) throws PreConditionException, PostConditionException;

    /* Operators */
    /*
    *  pre estfrappee(M, force) require ¬estDetruite(M) ∧ f >= 0
    * */
    public void estfrappee(Integer force) throws PreConditionException, PostConditionException;

    /* Observations */
     /*
    [invariants]
    estDetruite(M) =(min) pointsRes(M) ≤ 0
    [init]
    Terrain.largeur(init(l,h,p))=l
    Terrain.hauteur(init(l,h,p))=h
    pointsRes(init(l,h,p))=p
    Terrain.type(init(l,h))=MURAILLE

    [estfrappee]
    pointsRes(estfrappee(M)) = pointsRes(M) - f
     */


}

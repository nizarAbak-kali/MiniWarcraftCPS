package services;

import exceptions.PostConditionException;
import exceptions.PreConditionException;

/*
ABAK-KALI Nizar
BAYASSI Majd
*/
/**
 * Created by nizar on 05/05/15.
 */
public interface TerrainService {
    /* Observators */
    public Integer largeur();

    public Integer hauteur();

    public TerrainType type();

    public Integer orRestant();

    public boolean estLaminee();



    /* Invariants */
    // inv: estLaminee(T) =(min) orRestant(T) <= 0


    /* Initializers */
        /*
        * pre : largeur >= 0
        * pre : hauteur >= 0
        * pre : type != null
        * pre : orRestant > 0
        * post : largeur(init(l,h,o,t)) = l
        * post : hauteur(init(l,h,o,t)) = h
        * post : orRestant(init(l,h,o,t)) = o
        * post : type(init(l,h,o,t)) = t
     */
    public void init(Integer largeur, Integer hauteur, Integer orRestant, TerrainType type) throws PreConditionException, PostConditionException;


    /* Operators */
        /*
        * pre : orRestant() >= retrait(somme)
        * pre : somme > 0
        * pre : !estLaminee();
        * post : orRestant() == orRestant() - somme
        * */
    public void retrait(Integer somme) throws PreConditionException, PostConditionException;


}

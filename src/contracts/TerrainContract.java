package contracts;

import decorators.TerrainDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;
import services.TerrainType;

public class TerrainContract extends TerrainDecorator{
	public TerrainContract(){
		super();
	}
	
	public void checkInvariant() throws InvariantError{
		if(estLaminee()!=(orRestant()<=0))
			throw new InvariantError("");
	}
	
    /* Observators */
    public Integer largeur(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.largeur();
    }

    public Integer hauteur(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.hauteur();
    }

    public TerrainType type(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.type();
    }

    public Integer orRestant(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.orRestant();
    }

    public boolean estLaminee(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.estLaminee();
    }
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
    public void init(Integer largeur, Integer hauteur, Integer orRestant, TerrainType type) throws PreConditionException,PostConditionException{
    	//Pre
    	if(largeur<0)
    		throw new PreConditionException("");
    	if(hauteur<0)
    		throw new PreConditionException("");
    	if(type==TerrainType.NONE)
    		throw new PreConditionException("");
    	if(orRestant<=0)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	super.init(largeur, hauteur, orRestant, type);
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	if(largeur()!=largeur)
    		throw new PostConditionException("");
    	if(hauteur!=hauteur())
    		throw new PostConditionException("");
    	if(orRestant()!=orRestant)
    		throw new PostConditionException("");
    	if(type()!=type)
    		throw new PostConditionException("");
    }


    /* Operators */
        /*
        * pre : orRestant() >= somme
        * pre : somme > 0
        * pre : !estLaminee();
        * post : orRestant() == orRestant() - somme
        * */
    public void retrait(Integer somme) throws PreConditionException,PostConditionException{
    	//Pre
    	if(orRestant()<somme)
    		throw new PreConditionException("");
    	if(somme<=0)
    		throw new PreConditionException("");
    	if(estLaminee())
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	int old = orRestant();
    	//
    	super.retrait(somme);
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	if(orRestant()!=old-somme)
    		throw new PostConditionException("");
    }


}

package contracts;

import services.TerrainType;
import decorators.RouteDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public class RouteContract extends RouteDecorator{
	public RouteContract(){
		super();
	}
	
	public void checkInvariant() throws InvariantError{
	}
	
    /* Observators */
    public double facteurMult(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.facteurMult();
    }

    /* Constructors */
    /*
    pre init(largeur,hauteur,facteur) require largeur%2=1 ∧ hauteur%2=1 ∧ 0<facteur≤10
     */
    public void init(Integer largeur, Integer hauteur, double facteur) throws PreConditionException,PostConditionException{
    	//Pre
    	if(largeur%2!=1)
    		throw new PreConditionException("");
    	if(hauteur%2!=1)
    		throw new PreConditionException("");
    	if((facteur<=0)||(facteur>10))
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	super.init(largeur, hauteur,facteur);
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
    	if(facteurMult()!=facteur)
    		throw new PostConditionException("");
    	if(type()!=TerrainType.ROUTE)
    		throw new PostConditionException("");
    	
    }
}

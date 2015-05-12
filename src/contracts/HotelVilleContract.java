package contracts;

import services.Side;
import decorators.HotelVilleDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public class HotelVilleContract extends HotelVilleDecorator{
	
	public HotelVilleContract(){
		super();
	}
	
	public void checkInvariant() throws InvariantError{
		boolean condition = orRestant()<=0;
		if(estLaminee()!=condition)
			throw new InvariantError("L'hôtel de ville n'est pas laminé bien qu'il n'y ait plus d'or restant");
	}
	
    public Side side() {
    	try {
			checkInvariant();
		} catch (InvariantError e) {
		}
		return super.side();
	}


    /* Constructors */
     /*
        init : int × int × Side × int → [HotelVille]
        pre: init(largeur,hauteur,side,orRestant) require largeur%2=1 ∧ hauteur%2=1 ∧ orRestant>0 ∧ side!=NONE
        post side(init(l,h,s,o)) = s
     */
    public void init(Integer largeur, Integer hauteur, Side side, Integer orRestant) throws PreConditionException, PostConditionException{
    	try {
			checkInvariant();
		} catch (InvariantError e) {
		}
    	//Pre
    	if(largeur()%2!=1)
			throw new PreConditionException("Largeur!");
		if(hauteur()%2!=1)
			throw new PreConditionException("Hauteur!");
		if(orRestant()<=0)
			throw new PreConditionException("Or!");
		if(side()==Side.NONE)
			throw new PreConditionException("Side!");
		//Op
		super.init(largeur, hauteur, side, orRestant);
		//
		try {
			checkInvariant();
		} catch (InvariantError e) {
		}
		//Post
		if(side!=side())
			throw new PostConditionException("side!");
    }


    /* Operators */
    /*
        depot : [HotelVille] × int → [HotelVille]
        pre: depot(H,somme) require somme>0
    */
    public void depot(Integer somme) throws PreConditionException{
    	try {
			checkInvariant();
		} catch (InvariantError e) {
		}
    	//Pre
    	if(somme<=0)
			throw new PreConditionException("Somme!");
		//Op
		super.depot(somme);
		//
		try {
			checkInvariant();
		} catch (InvariantError e) {
		}
    }
}

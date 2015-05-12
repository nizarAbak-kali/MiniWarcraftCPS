package contracts;

import services.TerrainType;
import decorators.MurailleDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public class MurailleContract extends MurailleDecorator{
	public MurailleContract(){
		super();
	}
	public void checkInvariant() throws InvariantError{
		if(estDetruite()!=(pointsRes()<=0))
			throw new InvariantError("");
	}
    /* observators */
    public Integer pointsRes(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.pointsRes();
    }

    public boolean estDetruite(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.estDetruite();
    }

    /* Constructors */
    /*
    *  pre init(largeur,hauteur, pointsRes)
    *  require largeur%2=1 ∧ hauteur%2=1 ∧ pointsRes>0
    * */
    public void init(Integer largeur, Integer hauteur, Integer pointRes) throws PreConditionException,PostConditionException{
    	//Pre
    	if(largeur%2!=1)
    		throw new PreConditionException("");
    	if(hauteur%2!=1)
    		throw new PreConditionException("");
    	if(pointRes<=0)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	super.init(largeur, hauteur, pointRes);
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
    	if(pointsRes()!=pointRes)
    		throw new PostConditionException("");
    	if(type()!=TerrainType.MURAILLE)
    		throw new PostConditionException("");
    }

    /* Operators */
    /*
    *  pre estfrappee(M, force) require ¬estDetruite(M) ∧ f >= 0
    * */
    public void estfrappee(Integer force) throws PreConditionException,PostConditionException{
    	//Pre
    	if(estDetruite())
    		throw new PreConditionException("");
    	if(force<0)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	int old = pointsRes();
    	//
    	super.estfrappee(force);
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	if(pointsRes()!=old-force)
    		throw new PostConditionException("");
    }

}

package contracts;

import services.Side;
import services.TerrainType;
import decorators.MineDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public class MineContract extends MineDecorator{
	private boolean isAbandoned = false;
	private boolean isAccueil = false;
	
	public boolean getIsAbandoned(){
		return isAbandoned;
	}
	public boolean getIsAccueil(){
		return isAccueil;
	}
	
	public MineContract(){
		super();
	}
	
	public void checkInvariant() throws InvariantError{
		if(estAbandonnee()!=(abandonCompteur()==51))
			throw new InvariantError("Erreur d'abandon");
		if((abandonCompteur()<0)||(abandonCompteur()>51))
			throw new InvariantError("Erreur d'abandon");
		try {
			if(estAbandonnee()!=(side()==Side.NONE))
				throw new InvariantError("Erreur d'abandon");
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean condition = orRestant()<=0;
		if(estLaminee()!=condition)
			throw new InvariantError("La mine n'est pas laminée bien qu'il n'y ait plus d'or restant");
	}
	
	/* Observators */
    public boolean estAbandonnee(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
		}
    	return super.estAbandonnee();
    }

    public Integer abandonCompteur(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
		}
    	return super.abandonCompteur();
    }

    // pre side(M) require ¬estAbandonnee(M)
    public Side side() throws PreConditionException{
    	//Pre
    	if(estAbandonnee())
    		throw new PreConditionException("mine abandonnée");
    	try {
			checkInvariant();
		} catch (InvariantError e) {
		}
		return super.side();

    }

    /* Constructors */
    /* init : int × int × int x SIDE -> [Mine]
       pre init(largeur,hauteur,orRestant,side) require largeur%2=1 ∧ hauteur%2=1 ∧ orRestant>0 ∧ side != null

    */
    public void init(Integer largeur, Integer hauteur, Integer orRestant, Side side) throws PreConditionException, PostConditionException{
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
		super.init(largeur, hauteur, orRestant, side);
    	try {
		checkInvariant();
		} catch (InvariantError e) {
		}
    	//Post
    	if(side()!=Side.NONE)
    		throw new PostConditionException("side!");
    	if(largeur!=largeur())
    		throw new PostConditionException("largeur!");
    	if(hauteur!=hauteur())
    		throw new PostConditionException("hauteur");
    	if(type()!=TerrainType.MINE)
    		throw new PostConditionException("type!");
    	if(orRestant()!=orRestant)
    		throw new PostConditionException("or!");
    	if(abandonCompteur()!=51)
    		throw new PostConditionException("abandon!");
    }

    /* Operators */
    /*
    pre  acceuil(M,side) require ¬abandoned(M) ∧ side != NONE
    */
    public void acceuil(Side side) throws PreConditionException, PostConditionException{
    	try {
    		checkInvariant();
    		} catch (InvariantError e) {
    	}
    	//Pre 
    	if(isAbandoned)
    		throw new PreConditionException("abandoned");
    	//
    	int oldR = orRestant();
    	//
    	super.acceuil(side);
    	try {
    		checkInvariant();
    		} catch (InvariantError e) {
    	}
    	//Post
    	if(side()!=side)
    		throw new PostConditionException("");
    	if(abandonCompteur()!=0)
    		throw new PostConditionException("");
    	if(oldR!=orRestant())
    		throw new PostConditionException("");
    }


    /*
    pre abandoned(M) require ¬acceuil(M)
    */
    public void abandoned()throws PreConditionException, PostConditionException{
    	try {
    		checkInvariant();
    		} catch (InvariantError e) {
    	}
    	//Pre 
    	if(isAccueil)
    		throw new PreConditionException("");
    	//
    	int oldR = orRestant();
    	int oldCompt = abandonCompteur();
    	Side oldSide = side();
    	//
    	super.abandoned();
    	try {
    		checkInvariant();
    		} catch (InvariantError e) {
    	}
    	//Post
    	if(side()!=oldSide)
    		throw new PostConditionException("");
    	if(abandonCompteur()!=oldCompt+1)
    		throw new PostConditionException("");
    	if(oldR!=orRestant())
    		throw new PostConditionException("");
    }
}

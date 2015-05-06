package services;
/*
ABAK-KALI Nizar
BAYASSI Majd
*/
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public interface VillageoisService {

	/**
	 * Observators
	 */
	Race race();
    Side side();
   	int largeur();
   	int hauteur();
   	int force();
   	double vitesse();
   	int pointsDeVie();
   	int quantiteOr();
   	boolean estMort();
   	
	/**
	 * Constructors
	 * @throws PreConditionException 
	 * @throws InvariantError 
	 * @throws PostConditionException 
	 */
	/*pre largeur%2=1 ∧ hauteur%2=1 ∧ force ≥ 0 ∧ vitesse ≥ 0 ∧ pointsDeVie ≥ 0
	 *post
	 *race(init(r,s,l,h,f,v,p))=r
	 *side(init(r,s,l,h,f,v,p))=s
	 *largeur(init(r,s,l,h,f,v,p))=l
	 *hauteur(init(r,s,l,h,f,v,p))=h
	 *force(init(r,s,l,h,f,v,p))=f
	 *vitesse(init(r,s,l,h,f,v,p))=v
	 *pointsDeVie(init(r,s,l,h,f,v,p))=p
	 *quantiteOr(init(r,s,l,h,f,v,p))=0
	 */
    void init(Race r,Side s,int l,int h,int f,double v,int p) throws PreConditionException, InvariantError, PostConditionException;
	/**
	 * Operators
	 * @throws InvariantError 
	 * @throws PreConditionException 
	 * @throws PostConditionException 
	 */
	/*pre ¬estMort() ∧ s>0
	 *post
	 *pointsDeVie(retrait(s))=pointsDeVie() - s
	 *quantiteOr(retrait(s))=quantiteOr()
	 */
	void retrait(int s) throws InvariantError, PreConditionException, PostConditionException;
	
	/*
	 * post
	 * pointsDeVie(viderPoches())=pointsDeVie()
	 * quantiteOr(viderPoches())=0
	 */
	void viderPoches() throws InvariantError, PostConditionException;
	
	/*
	 * pre s > 0
	 * pointsDeVie(recupere(s))=pointsDeVie()
	 * quantiteOr(recupere(s))=quantiteOr()+s
	 */
	void recupere(int s) throws InvariantError, PreConditionException, PostConditionException;

	/**
	 * Invariants
	 */
	/*		
	 * 	estMort() = pointsDeVie(V) ≤ 0
	 *	quantiteOr() ≥ 0
	 */
}

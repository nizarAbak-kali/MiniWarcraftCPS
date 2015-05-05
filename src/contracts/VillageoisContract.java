package contracts;

import services.IVillageoisService.Race;
import services.IVillageoisService.Side;
import decorators.VillageoisDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public class VillageoisContract extends VillageoisDecorator{
	public VillageoisContract(){
		super();
	}
	
	public void checkInvariant() throws InvariantError{
		if(estMort() && pointsDeVie()>0)
			throw new InvariantError("Le villageois est mort mais ses points de vie sont supérieur à zéro!");
		if(!estMort() && pointsDeVie()<=0)
			throw new InvariantError("Le villageois n'est pas mort et ses points de vie sont inférieur à zéro en même temps!");
		if(quantiteOr()<0)
			throw new InvariantError("La quantité d'or possédée par le villageois est négative!");
	}
	
	@Override
	public Race race() {
		return super.race();
	}

	@Override
	public Side side() {
		return super.side();
	}

	@Override
	public int largeur() {
		return super.largeur();
	}

	@Override
	public int hauteur() {
		return super.hauteur();
	}

	@Override
	public int force() {
		return super.force();
	}

	@Override
	public double vitesse() {
		return super.vitesse();
	}

	@Override
	public int pointsDeVie() {
		return super.pointsDeVie();
	}

	@Override
	public int quantiteOr() {
		return super.quantiteOr();
	}

	@Override
	public boolean estMort() {
		return super.estMort();
	}

	@Override
	public void init(Race r, Side s, int l, int h, int f, double v, int p) throws PreConditionException, InvariantError, PostConditionException {
		//Check invariants
		checkInvariant();
		//Pre
		if(largeur()%2!=1)
			throw new PreConditionException("Largeur!");
		if(hauteur()%2!=1)
			throw new PreConditionException("Hauteur!");
		if(force()<0)
			throw new PreConditionException("Force!");
		if(vitesse()<0)
			throw new PreConditionException("Vitesse!");
		if(pointsDeVie()<0)
			throw new PreConditionException("Le mec est mort!");
		//Opération
		super.init(r, s, l, h, f, v, p);
		//Check invariants
		checkInvariant();
		//Post
		if(race()!=r)
			throw new PostConditionException("race");
		if(side()!=s)
			throw new PostConditionException("side");
		if(largeur()!=l)
			throw new PostConditionException("largeur");
		if(hauteur()!=h)
			throw new PostConditionException("hauteur");
		if(force()!=f)
			throw new PostConditionException("force");
		if(vitesse()!=v)
			throw new PostConditionException("vitesse");
		if(pointsDeVie()!=p)
			throw new PostConditionException("points de vie");
		if(quantiteOr()!=0)
			throw new PostConditionException("quantite d'or");
	}

	@Override
	public void retrait(int s) throws InvariantError, PreConditionException, PostConditionException {
		//Check invariants
		checkInvariant();
		//Pre
		if(estMort())
			throw new PreConditionException("Il est mort");
		if(s<0)
			throw new PreConditionException("retrait impossible");
		//Variables pour les post-conditions
		int oldPdv = pointsDeVie();
		int oldQuantite = quantiteOr();
		//Opération
		super.retrait(s);
		//Check invariants
		checkInvariant();
		//Post
		if(pointsDeVie()!=oldPdv-s)
			throw new PostConditionException("Calcul faux");
		if(quantiteOr()!=oldQuantite)
			throw new PostConditionException("Calcul faux");
	}

	@Override
	public void viderPoches() throws InvariantError, PostConditionException {
		//Check invariants
		checkInvariant();
		//Variables pour les post-conditions
		int oldPdv = pointsDeVie();
		//Opération
		super.viderPoches();
		//Check invariants
		checkInvariant();
		//Post
		if(pointsDeVie()!=oldPdv)
			throw new PostConditionException("Calcul faux");
		if(quantiteOr()!=0)
			throw new PostConditionException("Calcul faux");
	}

	@Override
	public void recupere(int s) throws InvariantError, PreConditionException, PostConditionException {
		//Check invariants
		checkInvariant();
		//Pre
		if(s<0)
			throw new PreConditionException("récupération impossible");
		//Variables pour les post-conditions
		int oldPdv = pointsDeVie();
		int oldQuantite = quantiteOr();
		//Opération
		super.recupere(s);
		//Check invariants
		checkInvariant();
		//Post
		if(pointsDeVie()!=oldPdv)
			throw new PostConditionException("Calcul faux");
		if(quantiteOr()!=oldQuantite+s)
			throw new PostConditionException("Calcul faux");

	}


}

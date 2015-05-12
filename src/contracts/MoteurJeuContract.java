package contracts;

import java.awt.Point;
import java.util.Set;

import services.Commande;
import services.HotelVilleService;
import services.MineService;
import services.MurailleService;
import services.Race;
import services.Resultat;
import services.RouteService;
import services.Side;
import services.VillageoisService;
import decorators.MoteurJeuDecorator;
import exceptions.InvariantError;
import exceptions.PostConditionException;
import exceptions.PreConditionException;

public class MoteurJeuContract extends MoteurJeuDecorator{

	public MoteurJeuContract(){
		super();
	}
	public void checkInvariant() throws InvariantError, PreConditionException{
		if((pasJeuCourant()<0)||(pasJeuCourant()>maxPasJeu()))
			throw new InvariantError("");
		if(estFini()!=(pasJeuCourant()==maxPasJeu()))
			throw new InvariantError("");
		if(estFini()!=(hotelDeVille(Side.PLAYER).orRestant()>=1664))
			throw new InvariantError("");
		if(estFini()!=(hotelDeVille(Side.ENEMY).orRestant()>=1664))
			throw new InvariantError("");
		if((resultatFinal()==Resultat.GAGNE)&&((hotelDeVille(Side.ENEMY).orRestant()>=1664)||(hotelDeVille(Side.PLAYER).orRestant()<1664)))
			throw new InvariantError("");
		if((resultatFinal()==Resultat.PERDU)&&((hotelDeVille(Side.ENEMY).orRestant()<1664)||(hotelDeVille(Side.PLAYER).orRestant()>=1664)))
			throw new InvariantError("");
		if((resultatFinal()==Resultat.EGALITE)&&((resultatFinal()==Resultat.GAGNE)||(resultatFinal()==Resultat.PERDU)))
			throw new InvariantError("");
		if(peutEntrer(1,1)!=(Point.distance(positionMineX(1), positionMineY(1), positionVillageoisX(1), positionVillageoisY(1))<=51))
			throw new InvariantError("");
		if(peutEntrerHotelVille(1, Side.PLAYER)!=(Point.distance(positionHotelVilleX(Side.PLAYER), positionHotelVilleY(Side.PLAYER), positionVillageoisX(1), positionVillageoisY(1))<=51))
			throw new InvariantError("");
	}
    /* Observartors */
    public Integer largeurTerrain(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.largeurTerrain();
    }

    public Integer hauteurTerrain(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.hauteurTerrain();
    }

    public Integer maxPasJeu(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.maxPasJeu();
    }

    public Integer pasJeuCourant(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.pasJeuCourant();
    }

    public Race playerRace(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.playerRace();
    }

    public Race enemyRace(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.enemyRace();
    }

    public boolean estFini(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.estFini();
    }

    /*
    * pre resultatFinal(M) require estFini(M)
    * */
    public Resultat resultatFinal() throws PreConditionException{
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//Pre
    	if(!estFini())
    		throw new PreConditionException("");
    	return super.resultatFinal();
    }

    public Set<Integer> numerosVillageois(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.numerosVillageois();
    }

    /*
    * pre getVillageois(M,num) require num ∈ numerosVillageois(M,num)
    * */
    public VillageoisService getVillageois(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosVillageois();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.getVillageois(num);
    }

    //pre positionVillageoisX(M,num) require num ∈ numerosVillageois(M,num)
    public Integer positionVillageoisX(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosVillageois();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionVillageoisX(num);
    }

    //pre positionVillageoisY(M,num) require num ∈ numerosVillageois(M,num)
    public Integer positionVillageoisY(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosVillageois();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionVillageoisY(num);
    }

    public Set<Integer> numerosMine(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.numerosMine();
    }
    //pre getMine(M,num) require num ∈ numerosMine(M,num)
    public MineService getMine(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosMine();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.getMine(num);
    }

    //pre positionMineX(M,num) require num ∈ numerosMine(M,num)
    public Integer positionMineX(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosMine();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionMineX(num);
    }

    //pre positionMineY(M,num) require num ∈ numerosMine(M,num)
    public Integer positionMineY(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosMine();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionMineY(num);
    } 


    public Set<Integer> numerosRoute(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.numerosRoute();
    }

    //  pre getRoute(M,num) require num ∈ numerosRoute(M,num)
    public RouteService getRoute(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosRoute();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.getRoute(num);
    }

    //pre positionRouteX(M,num) require num ∈ numerosRoute(M,num)
    public Integer positionRouteX(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosRoute();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionRouteX(num);
    }

    // pre positionRouteY(M,num) require num ∈ numerosRoute(M,num)
    public Integer positionRouteY(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosRoute();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionRouteY(num);
    }

    public Set<Integer> numerosMuraille(){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.numerosMuraille();
    }

    //pre getMuraille(M,num) require num ∈ numerosMuraille(M,num)
    public MurailleService getMuraille(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosMuraille();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.getMuraille(num);
    }

    //pre positionMurailleX(M,num) require num ∈ numerosMuraille(M,num)
    public Integer positionMurailleX(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosMuraille();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionMurailleX(num);
    }

    //pre positionMurailleY(M,num) require num ∈ numerosMuraille(M,num)
    public Integer positionMurailleY(Integer num) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosMuraille();
    	for(Integer i:v){
    		if(num == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.positionMurailleY(num);
    }

    public HotelVilleService hotelDeVille(Side side){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.hotelDeVille(side);
    }

    public Integer positionHotelVilleX(Side side){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.positionHotelVilleX(side);
    }

    public Integer positionHotelVilleY(Side side){
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		} catch (PreConditionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return super.positionHotelVilleY(side);
    }

    /*
    *  pre peutEntrer(M,numVillageois,numMine)
    *  require numVillageois ∈ numeroesVillageois(M,numVillageois)
        ∧ numMine ∈ numeroesMine(M,numMine)
    * */
    public boolean peutEntrer(Integer numVillageois, Integer numMine) throws PreConditionException{
    	//Pre
    	boolean find1 = false,find2 = false;
    	Set<Integer> v = numerosVillageois();
    	for(Integer i:v){
    		if(numVillageois == i){
    			find1=true;
    			break;
    		}
    	}
    	Set<Integer> m = numerosMine();
    	for(Integer i:m){
    		if(numMine == i){
    			find2=true;
    			break;
    		}
    	}
    	if(!find1||!find2)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.peutEntrer(numVillageois, numMine);
    }

    /*
    * pre peutEntrerHotelVille(M,numVillageois, s)
    * require numVillageois ∈ numeroesVillageois(M,numVillageois)
    * */
    public boolean peutEntrerHotelVille(Integer numVillageois, Side side) throws PreConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosVillageois();
    	for(Integer i:v){
    		if(numVillageois == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	return super.peutEntrerHotelVille(numVillageois, side);
    }

    /* Constructors */
    /*
    * pre init(largeur,hauteur,maxPas, r1, r2) require largeur≥ 600 ∧
     * hauteur≥ 400 ∧ maxPas≥ 0
    */
    public void init(Integer largeur, Integer hauteur, Integer maxpas, Race r1, Race r2) throws PreConditionException, PostConditionException{
    	//Pre
    	if(largeur<600)
    		throw new PreConditionException("");
    	if(hauteur<400)
    		throw new PreConditionException("");
    	if(maxpas<0)
    		throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	super.init(largeur, hauteur, maxpas, r1, r2);
    	//
    	if(largeurTerrain()!=largeur)
    		throw new PostConditionException("");
    	if(hauteurTerrain()!=hauteur)
    		throw new PostConditionException("");
    	if(maxPasJeu()!=maxpas)
    		throw new PostConditionException("");
    	if(pasJeuCourant()!=0)
    		throw new PostConditionException("");
    	if(resultatFinal()!=Resultat.EGALITE)
    		throw new PostConditionException("");
    	if(playerRace()!=r1)
    		throw new PostConditionException("");
    	if(enemyRace()!=r2)
    		throw new PostConditionException("");
    	
    }

    /* Opertators */
    /*
    *
    * pre pasJeu(M, comm, vill, arg) require vill ∈ numeroesVillageois(M) ∧ ¬estFini(M) ∧
    {
        comm = DEPLACER ⇒ 0 ≤ arg < 360
        comm = ENTRERMINE ⇒ arg ∈ numeroesMine(M) ∧ peutEntrer(M, vill, arg)
        comm = ENTRERHOTELVILLE ⇒ peutEntrerHotelVille(M, vill)
    }
 */
    public void pasJeu(Commande com, Integer villageois, Integer arg) throws PreConditionException, PostConditionException{
    	//Pre
    	boolean find = false;
    	Set<Integer> v = numerosVillageois();
    	for(Integer i:v){
    		if(villageois == i){
    			find=true;
    			break;
    		}
    	}
    	if(!find)
    		throw new PreConditionException("");
    	
    	if(estFini())
    		throw new PreConditionException("");
    	
    	if(com == Commande.DEPLACER)
    		if((arg<0)||(arg>=360))
    			throw new PreConditionException("");
    	
    	if(com == Commande.ENTRERMINE){
    		find = false;
        	v = numerosMine();
        	for(Integer i:v){
        		if(arg == i){
        			find=true;
        			break;
        		}
        	}
        	if(!find)
        		throw new PreConditionException("");
    		if(!peutEntrer(villageois, arg))
    			throw new PreConditionException("");
    	}

    	if(com == Commande.ENTRERHOTELVILLEs)
    		if(!peutEntrerHotelVille(villageois, Side.PLAYER))
    			throw new PreConditionException("");
    	//
    	try {
			checkInvariant();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
    	//
    	int oldpas = pasJeuCourant();
    	//
    	super.pasJeu(com, villageois, arg);
    	//
    	if(pasJeuCourant()!=oldpas+1)
    		throw new PostConditionException("");

    	if(com==Commande.ENTRERMINE){
    		v = numerosMine();
        	for(Integer i:v){
        		if(arg == i)
        			continue;
        		if((!getMine(i).estAbandonnee())&&(!getMine(i).getIsAbandoned()))
        			throw new PostConditionException("");
        	}
    	}
    	if(com!=Commande.ENTRERMINE){
    		v = numerosMine();
        	for(Integer i:v){
        		if((!getMine(i).estAbandonnee())&&(!getMine(i).getIsAbandoned()))
        			throw new PostConditionException("");
        	}
    	}
    }

     /*

    Observations :


   
    [init]
    

    [pasJeu]
    pasJeuCourant(pasJeu(M,c,numVillageois,arg))=pasJeuCourant(M) +1
    {
        c = ENTRERMINE ⇒ ∀ i ∈ numeroesMine(M) / arg , ¬Mine::estAbandonnee(getMine(M, i)) ⇒ Mine::abandoned(getMine(M, i))
        c != ENTRERMINE ⇒ ∀ i ∈ numeroesMine(M) , ¬Mine::estAbandonnee(getMine(M, i)) ⇒ Mine::abandoned(getMine(M, i))
    }
*/


}

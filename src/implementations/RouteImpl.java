package implementations;

import services.RouteService;
import services.TerrainType;

/**
 * Created by nizar on 08/05/15.
 */
public class RouteImpl extends TerrainImpl implements RouteService {
    double facteur;

    public RouteImpl() {
        super();
        facteur = 2.0;
    }

    public RouteImpl(int largeur, int hauteur, double facteur) {
        this.init(largeur, hauteur, facteur);
    }

    @Override
    public double facteurMult() {
        return this.facteur;
    }

    @Override
    public void init(Integer largeur, Integer hauteur, double facteur) {
        super.init(largeur, hauteur, 0, TerrainType.ROUTE);
        this.facteur = facteur;
    }
}

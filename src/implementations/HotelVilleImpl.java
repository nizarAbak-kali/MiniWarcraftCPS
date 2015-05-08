package implementations;

import services.HotelVilleService;
import services.Side;
import services.TerrainType;

/**
 * Created by nizar on 08/05/15.
 */
public class HotelVilleImpl extends TerrainImpl implements HotelVilleService {

    Side side;


    public HotelVilleImpl() {
        super();
        side = Side.PLAYER;
    }

    public HotelVilleImpl(int largeur, int hauteur, Side side, int orRestant) {
        this.init(largeur, hauteur, side, orRestant);
    }

    @Override
    public Side side() {
        return this.side;
    }


    @Override
    public void init(Integer largeur, Integer hauteur, Side side, Integer orRestant) {
        super.init(largeur, hauteur, orRestant, TerrainType.HOTELVILLE);
        this.side = side;
    }

    @Override
    public void depot(Integer somme) {
        super.o += somme;
    }
}

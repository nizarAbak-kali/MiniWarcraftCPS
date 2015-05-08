package implementations;

import services.MurailleService;
import services.TerrainType;

/**
 * Created by nizar on 08/05/15.
 */
public class MurailleImpl extends TerrainImpl implements MurailleService {
    int pointres;

    public MurailleImpl() {
        super();
        this.pointres = 100;
    }

    public MurailleImpl(int largeur, int hauteur, int pdv) {
        init(largeur, hauteur, pdv);
    }

    @Override
    public Integer pointsRes() {
        return this.pointres;
    }

    @Override
    public boolean estDetruite() {
        return (this.pointres <= 0);
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer pointRes) {
        super.init(largeur, hauteur, 0, TerrainType.MURAILLE);
        this.pointres = pointRes;

    }

    @Override
    public void estfrappee(Integer force) {
        this.pointres -= force;
    }
}

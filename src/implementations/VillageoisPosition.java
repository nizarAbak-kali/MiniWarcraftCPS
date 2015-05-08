package implementations;

import services.VillageoisService;

/**
 * Created by nizar on 08/05/15.
 */
public class VillageoisPosition extends ObjectPosition {
    VillageoisService v;


    public VillageoisPosition(VillageoisService v, int x, int y) {
        super(x, y);
        this.v = v;
    }

    public VillageoisService getVillageois() {
        return v;
    }
}

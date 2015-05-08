package implementations;

import services.MineService;

/**
 * Created by nizar on 08/05/15.
 */
public class MinePosition extends ObjectPosition {
    MineService m;

    public MinePosition(int x, int y) {
        super(x, y);
    }

    public MineService getMine() {
        return this.m;
    }
}

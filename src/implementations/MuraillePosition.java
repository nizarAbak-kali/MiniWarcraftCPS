package implementations;

import services.MurailleService;

/**
 * Created by nizar on 08/05/15.
 */
public class MuraillePosition extends ObjectPosition {
    MurailleService m;

    public MuraillePosition(MurailleService m, int x, int y) {
        super(x, y);
        this.m = m;
    }

    public MurailleService getMuraille() {
        return this.m;
    }

}

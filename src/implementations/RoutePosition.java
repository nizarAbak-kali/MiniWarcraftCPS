package implementations;

import services.RouteService;

/**
 * Created by nizar on 08/05/15.
 */
public class RoutePosition extends ObjectPosition {
    RouteService r;

    public RoutePosition(int x, int y) {
        super(x, y);
    }

    public RouteService getRoute() {
        return this.r;
    }
}

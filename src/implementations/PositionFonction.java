package implementations;

/**
 * Created by nizar on 08/05/15.
 */
public class PositionFonction {

    public PositionFonction() {

    }


    public int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public boolean collision(int x1, int y1, int x2, int y2) {
        return (x1 == x2) && (y1 == y2);
    }

}



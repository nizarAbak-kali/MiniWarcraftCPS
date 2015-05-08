package implementations;

import services.HotelVilleService;

/**
 * Created by nizar on 08/05/15.
 */
public class HotelVillePosition extends ObjectPosition {
    private HotelVilleService hotelVille;

    public HotelVillePosition(HotelVilleService h, int x, int y) {
        super(x, y);
        this.hotelVille = h;
    }

    public HotelVilleService getHotelVille() {
        return hotelVille;
    }

}

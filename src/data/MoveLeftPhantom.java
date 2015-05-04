/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: data/MoveLeftPhantom.java 2015-03-11 buixuan.
 * ******************************************************/
package data;

import specifications.PhantomService;
import tools.Position;

public class MoveLeftPhantom implements PhantomService {
    private Position position;

    public MoveLeftPhantom(Position p) {
        position = p;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position p) {
        position = p;
    }

    @Override
    public PhantomService.MOVE getAction() {
        return PhantomService.MOVE.LEFT;
    }
}

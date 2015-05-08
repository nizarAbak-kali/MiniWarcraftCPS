package implementations;

import services.TerrainService;
import services.TerrainType;

/**
 * Created by nizar on 07/05/15.
 */
public class TerrainImpl implements TerrainService {
    int l, h, o;
    TerrainType t;
    boolean estLaminee;


    @Override
    public Integer largeur() {
        return this.l;
    }

    @Override
    public Integer hauteur() {
        return this.h;
    }

    @Override
    public TerrainType type() {
        return this.t;
    }

    @Override
    public Integer orRestant() {
        return this.o;
    }

    @Override
    public boolean estLaminee() {
        return estLaminee;
    }

    @Override
    public void init(Integer largeur, Integer hauteur, Integer orRestant, TerrainType type) {
        this.o = orRestant;
        this.t = type;
        this.h = hauteur;
        this.l = largeur;
        this.estLaminee = false;
    }

    @Override
    public void retrait(Integer somme) {
        if (!this.estLaminee()) {
            this.o -= somme;
            if (this.o < 0)
                this.estLaminee = true;
        }
    }
}


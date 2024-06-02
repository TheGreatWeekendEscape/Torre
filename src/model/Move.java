package model;

public class Move {

    private int ad;
    private int def;
    private int hits;

    public Move(int ad, int def, int hits) {
        this.ad = ad;
        this.def = def;
        this.hits = hits;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}

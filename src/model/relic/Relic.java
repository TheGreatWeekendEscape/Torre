package model.relic;

import model.entity.Player;

public abstract class Relic {

    protected String id;
    protected String name;
    protected String desc;
    protected String foundText;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getFoundText() {
        return foundText;
    }

    public String getId() {
        return id;
    }

    public abstract void activate(Player player);


}

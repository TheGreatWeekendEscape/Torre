package model.spell;

import util.Console;

public enum Type {

    FIRE(Console.DEFAULT_COLOR + "[" + Console.FIRE_COLOR + "FUEGO" + Console.DEFAULT_COLOR + "]"),
    WIND(Console.DEFAULT_COLOR + "[" + Console.WIND_COLOR + "VIENTO" + Console.DEFAULT_COLOR + "]"),
    NORMAL(Console.DEFAULT_COLOR + "[" + Console.NORMAL_COLOR + "NORMAL" + Console.DEFAULT_COLOR + "]"),
    DARKNESS(Console.DEFAULT_COLOR + "[" + Console.DARKNESS_COLOR + "OSCURIDAD" + Console.DEFAULT_COLOR + "]"),
    WATER(Console.DEFAULT_COLOR + "[" + Console.WATER_COLOR + "AGUA" + Console.DEFAULT_COLOR + "]"),
    ROCK(Console.DEFAULT_COLOR + "[" + Console.ROCK_COLOR + "ROCA" + Console.DEFAULT_COLOR + "]"),
    PLANT(Console.DEFAULT_COLOR + "[" + Console.PLANT_COLOR + "PLANTA" + Console.DEFAULT_COLOR + "]"),
    ICE(Console.DEFAULT_COLOR + "[" + Console.ICE_COLOR + "HIELO" + Console.DEFAULT_COLOR + "]");


    String displayName;

    private Type(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean isGoodVs(Type type) {
        if (this == Type.FIRE && type == Type.PLANT) {
            return true;
        }
        if (this == Type.ICE && type == Type.ROCK) {
            return true;
        }
        if (this == Type.WATER && type == Type.FIRE) {
            return true;
        }
        if (this == Type.WIND && type == Type.FIRE) {
            return true;
        }
        if (this == Type.DARKNESS && type == Type.WIND) {
            return true;
        }
        if (this == Type.NORMAL && type == Type.DARKNESS) {
            return true;
        }
        return false;
    }

    public boolean isBadVs(Type type) {
        if (this == Type.FIRE && type == Type.WATER) {
            return true;
        }
        if (this == Type.ICE && type == Type.FIRE) {
            return true;
        }
        if (this == Type.WATER && type == Type.PLANT) {
            return true;
        }
        if (this == Type.WIND && type == Type.ROCK) {
            return true;
        }
        if (this == Type.DARKNESS && type == Type.FIRE) {
            return true;
        }
        return false;
    }


}

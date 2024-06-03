package model.spell;

import model.entity.Entity;

public class AtaqueBasico extends Spell {

    public AtaqueBasico (Entity caster) {
        super(caster);
    }

    @Override
    void init() {
        this.name = "Ataque basico";
        this.desc = "Causa 6 de daño";
        this.damage = 3;
        this.defense = 0;
        this.hits = 1;
        this.type = Type.NOTYPE;

    }

    protected String name;
    protected String desc;
    protected int damage;
    protected int defense;
    protected int hits;
    protected Type type;
    protected Entity target;
    protected Entity caster;

    @Override
    void cast() {
        super.target.loseHp(super.damage);
    }
}

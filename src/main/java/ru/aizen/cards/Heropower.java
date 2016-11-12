package ru.aizen.cards;

import ru.aizen.enums.CardType;

import java.util.Map;

public class Heropower extends AbstractCard{
    private Integer cost;

    private enum Use{
        ACTIVE,
        PASSIVE
    }
    private Use use = Use.ACTIVE;
    private boolean autoUse = false;

    public Heropower(Stats stats){
        super();
        this.type = CardType.HEROPOWER;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(String cost) {
        try{
            this.cost = Integer.parseInt(cost);
        } catch (NumberFormatException e){
            this.cost = null;
        }

    }

    public Use getUse() {
        return use;
    }

    public void setUse(boolean trigger) {
        if (trigger) {
            use = Use.PASSIVE;
        }
    }

    public boolean isAutoUse() {
        return autoUse;
    }

    public void setAutoUse(boolean auto) {
        if (auto){
            this.autoUse = true;
        }
    }
}

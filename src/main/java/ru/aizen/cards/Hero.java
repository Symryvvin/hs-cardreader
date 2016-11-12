package ru.aizen.cards;

import ru.aizen.enums.CardType;
import ru.aizen.parser.CardXMLHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hero extends AbstractCard{
    private boolean playable;
    private boolean boss;
    private List<Heropower> heropowers = new ArrayList<>();

    public Hero(Stats stats){
        super();
        this.type = CardType.HERO;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public List<Heropower> getHeropowers() {
        return heropowers;
    }

    public void setHeropowers(String heropowers) {
        String[] hpArray = heropowers.split(",");
        for (String hp : hpArray){
            this.heropowers.add(CardXMLHandler.heropowers.get(hp));
        }
    }

}

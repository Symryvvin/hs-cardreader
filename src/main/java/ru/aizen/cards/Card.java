package ru.aizen.cards;

import com.sun.istack.internal.NotNull;
import ru.aizen.error.CardParserError;
import ru.aizen.enums.CardClass;
import ru.aizen.enums.CardType;
import ru.aizen.enums.Race;
import ru.aizen.enums.Rarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Card extends AbstractCard {
    private CardClass cardClass;
    private Rarity rarity;
    private Race race;
    private Integer cost;
    private Integer attack;
    private Integer health;
    private Integer durability;
    private Integer[] dust;

    private List<String> entourageCards = new ArrayList<>();
    private List<String> mechanics = new ArrayList<>();

    private String howCommonGet;
    private String howGoldGet;
    private String flavor;
    private String artist;

    public static class Minion {
        private Race race;
        private Integer attack;
        private Integer health;

        public Minion(Stats stats) {
            attack = parseAttack(stats.get(Stats.ATTACK));
            health = parseHealth(stats.get(Stats.HEALTH));
            race = getRace(stats.get(Stats.RACE));
        }

        public Card create(){
            return new Card(this);
        }

        private Integer parseAttack(String value){
            return value == null ? 0 : Integer.parseInt(value);
        }

        private Integer parseHealth(String value){
            return value == null ? 0 : Integer.parseInt(value);
        }

        private Race getRace(String value){
            return value == null ? null : Race.valueOf(value);
        }
    }

    public static class Spell {

        public Spell(Stats stats) {
        }

        public Card create(){
            return new Card(this);
        }
    }

    public static class Weapon {
        private Integer attack;
        private Integer durability;

        public Weapon(Stats stats) {
            attack = parseAttack(stats.get(Stats.ATTACK));
            durability = parseDurability(stats.get(Stats.DURABILITY));
        }

        public Card create(){
            return new Card(this);
        }

        private Integer parseAttack(String value){
            return value == null ? 0 : Integer.parseInt(value);
        }

        private Integer parseDurability(String value){
            return value == null ? 0 : Integer.parseInt(value);
        }
    }

    private Card(Minion minion){
        this.attack = minion.attack;
        this.health = minion.health;
        this.race = minion.race;
        this.type = CardType.MINION;
    }

    private Card(Spell spell){
        this.type = CardType.SPELL;
    }

    private Card(Weapon weapon){
        this.attack = weapon.attack;
        this.durability = weapon.durability;
        this.type = CardType.WEAPON;
    }

    public void initStats(Stats stats) throws CardParserError {
        this.cardClass = CardClass.valueOf(stats.get(Stats.CLASS));
        this.rarity = Rarity.valueOf(stats.get(Stats.RARITY));
        this.cost = parseCost(stats.get(Stats.COST));
        if (collectible){
            dustCalculate();
            this.howCommonGet = stats.get(Stats.COMMON);
            this.howGoldGet = stats.get(Stats.GOLD);
            this.flavor = stats.get(Stats.FLAVOR);
            this.artist = stats.get(Stats.ARTIST);
        }

    }

    private Integer parseCost(String value){
        return value == null ? 0 : Integer.parseInt(value);
    }

    private void dustCalculate() throws CardParserError {
        if (rarity != null){
            switch (rarity){
                case FREE:
                    this.dust = null;
                    break;
                case COMMON:
                    this.dust = new Integer[]{40, 400, 5, 50};
                    break;
                case RARE:
                    this.dust = new Integer[]{100, 800, 20, 100};
                    break;
                case EPIC:
                    this.dust = new Integer[]{400, 1600, 100, 400};
                    break;
                case LEGENDARY:
                    this.dust = new Integer[]{1600, 3200, 400, 1600};
                    break;
            }
        } else {
            throw new CardParserError("Can`t calculate dust. Rarity is not defined");
        }
    }

    public CardClass getCardClass() {
        return cardClass;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = Rarity.valueOf(rarity);
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(String cost) {
        // if manacost of card is not defined in execute file, but actually cost is "0"
        if (cost == null){
            this.cost = 0;
        } else {
            this.cost = Integer.parseInt(cost);
        }
    }

    public List<String> getEntourageCards() {
        return entourageCards;
    }

    public void setEntourageCards(List<String> entourageCards) {
        if (entourageCards.size() != 0)
            this.entourageCards = entourageCards;
        else
            this.entourageCards = null;

    }

    public List<String> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<String> mechanics) {
        if (mechanics.size() != 0)
            this.mechanics = mechanics;
        else
            this.mechanics = null;
    }

    // getters for specific fields health, attack, durability, race

    public Race getRace() {
        return race;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getDurability() {
        return durability;
    }

    // getter fo dust

    public Integer[] getDust() {
        return dust;
    }

    // if collectible card

    public String getHowCommonGet() {
        return howCommonGet;
    }

    public void setHowCommonGet(String howCommonGet) {
        this.howCommonGet = howCommonGet;
    }

    public String getHowGoldGet() {
        return howGoldGet;
    }

    public void setHowGoldGet(String howGoldGet) {
        this.howGoldGet = howGoldGet;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

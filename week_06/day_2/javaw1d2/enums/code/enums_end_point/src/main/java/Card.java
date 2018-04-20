public class Card {

    private SuitType suit;
    private RankType value;

    public Card(SuitType suit, RankType value) {
        this.suit = suit;
        this.value = value;
    }

    public SuitType getSuit(){
        return this.suit;
    }

    public RankType getValue() {
        return value;
    }

    public int getValueFromEnum() {
        return this.value.getValue();
    }
}
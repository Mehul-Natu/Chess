package Chess.Util;

public class Pair<X, Y> {

    X fieldOne;
    Y FieldTwo;

    public Pair(X fieldOne, Y fieldTwo) {
        this.fieldOne = fieldOne;
        FieldTwo = fieldTwo;
    }

    public X getFieldOne() {
        return fieldOne;
    }

    public Y getFieldTwo() {
        return FieldTwo;
    }
}

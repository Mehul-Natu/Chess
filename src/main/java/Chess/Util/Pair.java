package Chess.Util;

public class Pair<X, Y> {

    X fieldOne;
    Y FieldTwo;

    public Pair() {
    }

    public void setFieldOne(X fieldOne) {
        this.fieldOne = fieldOne;
    }

    public void setFieldTwo(Y fieldTwo) {
        FieldTwo = fieldTwo;
    }

    public X getFieldOne() {
        return fieldOne;
    }

    public Y getFieldTwo() {
        return FieldTwo;
    }
}

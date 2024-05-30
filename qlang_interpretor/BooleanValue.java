public class BooleanValue extends Value {
    private Boolean val;

    public BooleanValue(Boolean val) {
        this.val = val;
    }

    public Boolean getValue() {
        return val;
    }

    public String toString() {
        return val.toString();
    }

    @Override
    public Value not() {
        return new BooleanValue(!val);
    }

    @Override
    public Value and(Value v) {
        return new BooleanValue(val & ((BooleanValue) v).getValue());
    }

    @Override
    public Value or(Value v) {
        return new BooleanValue(val | ((BooleanValue) v).getValue());
    }

    @Override
    public Value xor(Value v) {
        return new BooleanValue(val ^ ((BooleanValue) v).getValue());
    }

    @Override
    public Value implies(Value v) {
        return new BooleanValue(!val || ((BooleanValue) v).getValue());
    }

    @Override
    public Value equal(Value v) {
        return new BooleanValue(val == ((BooleanValue) v).getValue());
    }

    @Override
    public Value andThen(Value v) {
        return new BooleanValue(val && ((BooleanValue) v).getValue());
    }

    @Override
    public Value orElse(Value v) {
        return new BooleanValue(val || ((BooleanValue) v).getValue());
    }

    @Override
    public Value notEqual(Value v) {
        return new BooleanValue(val != ((BooleanValue) v).getValue());
    }
}

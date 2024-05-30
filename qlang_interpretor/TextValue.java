public class TextValue extends Value {
    private String val;

    public TextValue(String val) {
        this.val = val;
    }

    public String getValue() {
        return val;
    }

    public String toString() {
        return val;
    }

    @Override
    public Value add(Value v) {
        return new TextValue(val + ((TextValue) v).getValue());
    }
    
    @Override
    public Value equal(Value v) {
        return new BooleanValue(val.equals(((TextValue) v).getValue()));
    }

    @Override
    public Value notEqual(Value v) {
        return new BooleanValue(!val.equals(((TextValue) v).getValue()));
    }
}

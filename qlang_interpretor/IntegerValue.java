public class IntegerValue extends Value {
    private Integer val;

    public IntegerValue(Integer val) {
        this.val = val;
    }

    public Integer getValue() {
        return val;
    }

    public String toString() {
        return val.toString();
    }

    @Override
    public Value add(Value v) {
        return new IntegerValue(val + ((IntegerValue) v).getValue());
    }

    @Override
    public Value subtract(Value v) {
        return new IntegerValue(val - ((IntegerValue) v).getValue());
    }

    @Override
    public Value multiply(Value v) {
        return new IntegerValue(val * ((IntegerValue) v).getValue());
    }

    @Override
    public Value divide(Value v) {
        return new IntegerValue(val / ((IntegerValue) v).getValue());
    }

    @Override
    public Value mod(Value v) {
        return new IntegerValue(val % ((IntegerValue) v).getValue());
    }

    @Override
    public Value equal(Value v) {
        return new BooleanValue(val == ((IntegerValue) v).getValue());
    }

    @Override
    public Value notEqual(Value v) {
        return new BooleanValue(val != ((IntegerValue) v).getValue());
    }

    @Override
    public Value unaryMinus() {
        return new IntegerValue(-val);
    }

    @Override
    public Value greaterThan(Value v) {
        return new BooleanValue(val > ((IntegerValue) v).getValue());
    }

    @Override
    public Value lessThan(Value v) {
        return new BooleanValue(val < ((IntegerValue) v).getValue());
    }

    @Override
    public Value greaterThanOrEqual(Value v) {
        return new BooleanValue(val >= ((IntegerValue) v).getValue());
    }

    @Override
    public Value lessThanOrEqual(Value v) {
        return new BooleanValue(val <= ((IntegerValue) v).getValue());
    }

    @Override
    public Value convertTo(String t) {
        if (t.equals("real")) {
            return new RealValue(val.doubleValue());
        } 
        else if (t.equals("integer")) {
            return this;
        } 
        else if (t.equals("text")) {
            return new TextValue(val.toString());
        }
        else {
            throw new RuntimeException("Conversion to " + t + " not supported");
        }
    }
}

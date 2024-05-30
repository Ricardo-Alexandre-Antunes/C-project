public class RealValue extends Value {
    private Double val;

    public RealValue(Double val) {
        this.val = val;
    }

    public Double getValue() {
        return val;
    }
    
    public String toString() {
        return val.toString();
    }

    @Override
    public Value add(Value v) {
        return new RealValue(val + ((RealValue) v).getValue());
    }

    @Override
    public Value subtract(Value v) {
        return new RealValue(val - ((RealValue) v).getValue());
    }

    @Override
    public Value multiply(Value v) {
        return new RealValue(val * ((RealValue) v).getValue());
    }

    @Override
    public Value divide(Value v) {
        return new RealValue(val / ((RealValue) v).getValue());
    }

    @Override
    public Value mod(Value v) {
        return new RealValue(val % ((RealValue) v).getValue());
    }

    @Override
    public Value equal(Value v) {
        return new BooleanValue(val == ((RealValue) v).getValue());
    }

    @Override
    public Value notEqual(Value v) {
        return new BooleanValue(val != ((RealValue) v).getValue());
    }

    @Override
    public Value unaryMinus() {
        return new RealValue(-val);
    }

    @Override
    public Value greaterThan(Value v) {
        return new BooleanValue(val > ((RealValue) v).getValue());
    }

    @Override
    public Value lessThan(Value v) {
        return new BooleanValue(val < ((RealValue) v).getValue());
    }

    @Override
    public Value greaterThanOrEqual(Value v) {
        return new BooleanValue(val >= ((RealValue) v).getValue());
    }

    @Override
    public Value lessThanOrEqual(Value v) {
        return new BooleanValue(val <= ((RealValue) v).getValue());
    }

    @Override
    public Value convertTo(String t) {
        if (t.equals("text")) {
            return new TextValue(val.toString());
        } 
        else if (t.equals("integer")) {
            return new IntegerValue(val.intValue());
        } 
        else if (t.equals("real")) {
            return this;
        } 
        else {
            throw new RuntimeException("Conversion to " + t + " not supported");
        }
    }
}

import java.util.regex.Pattern;

public class TextValue extends Value {
    private String val;
    private final String REGEX_INT = "^-?\\d+$";
    private final String REGEX_DOUBLE = "^-?\\d+(\\.\\d+)?$";

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

    @Override
    public Value convertTo(String t) {
        if (t.equals("text")) {
            return this;
        } 
        else if (t.equals("integer")) {
            if (Pattern.matches(REGEX_INT, val)) {
                return new IntegerValue(Integer.parseInt(val));
            } 
            else {
                ErrorHandling.printError("Invalid type conversion!");
                return null;
            }
        } 
        else if (t.equals("real")) {
            if (Pattern.matches(REGEX_DOUBLE, val)) {
                return new RealValue(Double.parseDouble(val));
            } 
            else {
                ErrorHandling.printError("Invalid type conversion!");
                return null;
            }
        } 
        else {
            throw new RuntimeException("Conversion to " + t + " not supported");
        }
    }
}

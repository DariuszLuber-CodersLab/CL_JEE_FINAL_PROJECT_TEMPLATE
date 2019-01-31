package pl.coderslab.model;

public class ValidationError {

    private String symbol;
    private String attributeName;
    private String message;

    public ValidationError(String symbol, String attributeName, String message) {
        this.symbol = symbol;
        this.attributeName = attributeName;
        this.message = message;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

import java.io.Serializable;

public class Packet implements Serializable {
    private String operator;
    private double firstOperation;
    private double secondOperation;
    private double result;
    private long time;

    Packet(double result, long time) {
        this.result = result;
        this.time = time;
    }

    Packet(String type, double firstOperation, double secondOperation) {
        this.operator = type;
        this.firstOperation = firstOperation;
        this.secondOperation = secondOperation;
    }

    Packet(String type, double op1) {
        this.operator = type;
        this.firstOperation = op1;
    }

    String getOperator() {
        return operator;
    }

    double getFirstOperation1() {
        return firstOperation;
    }

    double getSecondOperation() {
        return secondOperation;
    }

    @Override
    public String toString() {
        return "Calculation Time: " + time + "ns \nResult: " + result;
    }

}
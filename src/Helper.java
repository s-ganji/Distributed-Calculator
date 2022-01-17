class Helper {
    static double calculate(Packet packet) {
        double firstOperation = packet.getFirstOperation1();
        double secondOperation = packet.getSecondOperation();
        switch (packet.getOperator()) {
            case "ADD":
                return firstOperation + secondOperation;
            case "SUBTRACT":
                return firstOperation - secondOperation;
            case "DIVIDE":
                return firstOperation / secondOperation;
            case "MULTIPLY":
                return firstOperation * secondOperation;
            case "SIN":
                return Math.sin(firstOperation * Math.PI / 180);
            case "COS":
                return Math.cos(firstOperation * Math.PI / 180);
            case "TAN":
                return Math.tan(firstOperation * Math.PI / 180);
            case "COT":
                return 1 / Math.tan(firstOperation * Math.PI / 180);
        }
        return firstOperation;
    }
}

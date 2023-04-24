package practiceTasks.fourth;

public class EnhancedBus extends Bus{
    private double fuelConsumption;
    private double fuelLeft;
    private boolean isConditionerOn;

    public EnhancedBus(int numberOfSeats, double fuelConsumption, double fuelLeft){
        super(numberOfSeats);
        this.fuelConsumption = fuelConsumption;
        this.fuelLeft = fuelLeft;
    }

    public double calculateMaxDistance(){
        fuelConsumption = fuelConsumption *(1 +(0.05 * passengers.size()));
        if (isConditionerOn){
            fuelConsumption *= 1.1;
        }
        return fuelLeft/fuelConsumption;
    }

    public boolean isConditionerOn() {
        return isConditionerOn;
    }

    public void setConditioner(boolean condition) {
        isConditionerOn = condition;
    }
}

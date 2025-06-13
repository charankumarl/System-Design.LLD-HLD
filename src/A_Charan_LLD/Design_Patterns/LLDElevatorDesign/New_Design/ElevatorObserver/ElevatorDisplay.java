package A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.ElevatorObserver;

import A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Elevator.Elevator;
import A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Enum.*;

public class ElevatorDisplay implements ElevatorObserver {

    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState state) {
        // Display the new state of the elevator
        System.out.println("Elevator " + elevator.getId() + " state changed to " + state);
    }

    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        // Display the elevator's movement to a new floor
        System.out.println("Elevator " + elevator.getId() + " moved to floor " + floor);
    }
}

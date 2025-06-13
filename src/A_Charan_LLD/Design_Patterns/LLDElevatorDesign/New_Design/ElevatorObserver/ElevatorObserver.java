package A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.ElevatorObserver;

import A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Elevator.Elevator;
import A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Enum.*;

public interface ElevatorObserver {

    // Called when an elevator's state changes
    void onElevatorStateChange(Elevator elevator, ElevatorState state);


    // Called when an elevator changes its current floor
    void onElevatorFloorChange(Elevator elevator, int floor);
}

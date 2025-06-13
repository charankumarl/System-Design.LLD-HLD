package A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Enum;

public enum ElevatorState {

    IDLE,         // The elevator is not moving, waiting for requests
    MOVING,       // The elevator is in motion (either up or down)
    STOPPED,      // The elevator has temporarily stopped (e.g., at a floor)
    MAINTENANCE   // The elevator is out of service and undergoing maintenance
}

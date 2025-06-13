package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Solution;

public class Bike {

    private Gear_Strategy gearStrategy;  // has a relationship with Gear_Strategy interface

     Bike(Gear_Strategy gearStrategy){  // constructor injection to set the gear strategy. create a gear object

        this.gearStrategy = gearStrategy;  // based on object paticular gear strategy will be set. automatic, manual
     }

    void gear(){
        gearStrategy.gear();
    }
}

package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o1_Stratergy.Solution;

public class Main {

    public static void main(String[] args) {

        Bike sports_bike = new Bike(new Manual_Gear());
        sports_bike.gear();

        Bike scooty = new Bike(new Automatic_Gear());  // Both scooty and electric have same gear system. Uses automatic gear class
        scooty.gear();

        Bike electric = new Bike(new Automatic_Gear());  // no duplication of code.
        electric.gear();

    }// without if else decided the gear system dynamically
}

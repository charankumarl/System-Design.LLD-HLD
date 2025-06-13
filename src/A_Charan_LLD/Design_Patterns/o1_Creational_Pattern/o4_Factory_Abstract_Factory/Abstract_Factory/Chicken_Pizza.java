package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Abstract_Factory;

public class Chicken_Pizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicken Pizza");
    }

    @Override
    public void box() {
        System.out.println("Packing Chicken Pizza");
    }
}

class Chicken_Pizza1 implements Pizza, A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory.Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza1");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicken Pizza1");
    }

    @Override
    public void box() {
        System.out.println("Packing Chicken Pizza1");
    }
}

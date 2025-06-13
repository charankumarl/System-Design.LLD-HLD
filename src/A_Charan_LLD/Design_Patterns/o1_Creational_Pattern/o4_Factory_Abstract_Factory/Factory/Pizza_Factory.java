package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Factory;

public class Pizza_Factory {

    public static Pizza createPizza(String type){

        Pizza pizza = null;

        if(type.equals("veg")){
            pizza = new Veg_Pizza();
        }
        else if(type.equals("chicken")){
            pizza = new Chicken_Pizza();
        }
        else{
            System.out.println("Invalid Pizza type");
        }

        return pizza;
    }
}

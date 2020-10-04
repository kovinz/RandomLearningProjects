import java.util.Date;

public class Main {

    public static void main(String[] args) {
        GenericItem genericItem1 = new GenericItem(1, "apple", (float) 20.5);
        GenericItem genericItem2 = new GenericItem(2, "orange", (float) 30.6);
        GenericItem genericItem3 = new GenericItem(3, "champ", (float) 152420.9);

        genericItem1.printAll();
        genericItem2.printAll();
        genericItem3.printAll();

        FoodItem foodItem = new FoodItem();
        TechnicalItem technicalItem = new TechnicalItem();
        GenericItem[] items = {foodItem, technicalItem};
        for (GenericItem item: items) {
            item.printAll();
        }

        FoodItem foodItem1 = new FoodItem(1, "porridge", 104, Category.FOOD, new Date(), (short) 12);
        FoodItem foodItem2 = new FoodItem(2, "milk", 54, Category.FOOD, new Date(), (short) 112);
        System.out.println(foodItem1.equals(foodItem2));

        FoodItem foodItem3 = foodItem1.clone();
        System.out.println(foodItem1.equals(foodItem3));
    }
}

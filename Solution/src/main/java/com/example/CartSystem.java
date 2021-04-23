package Solution.src.main.java.com.example;

import java.util.Iterator;
import java.util.Map;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        System.out.println("Cart:");
        System.out.printf("%-20s"+" | "+ "%-20s"+" | "+"%-10s"+" | "+"%-10s"+" | "+"%-10s", "Name","Description","Price","Quantity","Sub Total");
        System.out.println();
        Iterator <Map.Entry<String, Item>> iterator = super.getItemCollection().entrySet().iterator();
        Double subtotal = 0.0;
        while(iterator.hasNext()) {
      	  Map.Entry<String, Item> pair = iterator.next();
      	  subtotal = subtotal+ pair.getValue().getItemPrice()*pair.getValue().getQuantity();
         System.out.printf("%-20s"+" | "+ "%-20s"+" | "+"%-10.2f"+" | "+"%-10d"+ " | "+"%-10.2f\n",
          pair.getValue().getItemName(),
        	pair.getValue().getItemDesc(),
         	pair.getValue().getItemPrice(),
        	pair.getValue().getQuantity(),
        	pair.getValue().getItemPrice()*pair.getValue().getQuantity()
        	);
        }
        System.out.println();
        System.out.println();
        System.out.printf("%-20s"+" | "+"%-20.2f\n","Pre-tax Total",subtotal);
        Double tax = subtotal*0.05;
        System.out.printf("%-20s"+" | "+"%-20.2f\n","Tax",tax);
        System.out.printf("%-20s"+" | "+"%-20.2f\n","Total",subtotal+tax);
        }
    }


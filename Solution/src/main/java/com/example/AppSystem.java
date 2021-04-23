package Solution.src.main.java.com.example;

import java.util.Iterator;
import java.util.Map;

public class AppSystem extends TheSystem {
    AppSystem() {
    	
    }

    @Override
    public void display() {

       System.out.println("AppSystem Inventory:");
      System.out.printf("%-20s %-20s %-10s %-10s\n", "Name","Description","Price","Available Quantity");
      Iterator <Map.Entry<String, Item>> iterator = super.getItemCollection().entrySet().iterator();
      while(iterator.hasNext()) {
    	  Map.Entry<String, Item> pair = iterator.next();
       System.out.printf("%-20s %-20s %-10.2f %-10d\n",
        pair.getValue().getItemName(),
      	pair.getValue().getItemDesc(),
       	pair.getValue().getItemPrice(),
      	pair.getValue().getAvailableQuantity());
      }	
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
    	try{
    	if(super.getItemCollection().containsValue(item))
    	{
    		System.out.println(item.getItemName()+" is already in the App System");
    		return false;
    	}
    	
    	else 
    	{
    		super.getItemCollection().put(item.getItemName(), new Item(item.getItemName(),item.getItemDesc(),item.getItemPrice(),item.getAvailableQuantity()));
    		return true;
    		
    	}
		
    	 
    	}
    catch(NullPointerException e)
    {
    	e.printStackTrace();
    	return false;
    }
    }
         

    public Item reduceAvailableQuantity(String item_name) {
    	if(!super.itemCollection.containsKey(item_name))
        {
            return null;
        }
        else if(super.itemCollection.get(item_name).getAvailableQuantity() == 0)
        {
            itemCollection.remove(item_name);
            return null;
        }
        else{
            Integer aval = super.itemCollection.get(item_name).getAvailableQuantity();
            itemCollection.get(item_name).setAvailableQuantity(aval - 1);
            if (itemCollection.get(item_name).getAvailableQuantity() == 0) {
                itemCollection.remove(item_name);
                return null;
        }
        return itemCollection.get(item_name);

       }
	
    }
}
        
    
    



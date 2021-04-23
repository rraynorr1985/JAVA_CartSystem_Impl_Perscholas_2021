package Solution.src.main.java.com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
	
	HashMap<String,Item> itemCollection;
   

    TheSystem() {
        this.itemCollection=new HashMap<String,Item>();
        if(getClass().getSimpleName().equals("AppSystem"))
        {
        	try {
        	String s = "./src/Solution/resources/sample.txt";
        	File file = new File(s);
				Scanner sc = new Scanner(file);
				while(sc.hasNext())
				{
					String[] itemInfo = sc.nextLine().split("  ");
					Item it = new Item();
					it.setItemName(itemInfo[0]);
					it.setItemDesc(itemInfo[1]);
					it.setItemPrice(Double.parseDouble(itemInfo[2]));
					it.setAvailableQuantity(Integer.parseInt(itemInfo[3]));
//					itemCollection.put(itemInfo[0], new Item(itemInfo[0],itemInfo[1],Double.parseDouble(itemInfo[2]),Integer.parseInt(itemInfo[3])));
					itemCollection.put(itemInfo[0], it);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
    }
    
    public HashMap<String, Item> getItemCollection(){
		return itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        if(item.getQuantity()>= item.getAvailableQuantity())
        {
        	System.out.println("System is unable to add "+ item.getItemName()+" to the cart.System only has "+item.getAvailableQuantity()+" "+item.getItemName()+"s.");
        	return false;
        }
        else return true;
    }
    
    public Boolean add(Item item) {
        if(item.equals(null))
        {
        	return false;
        }
        else if(getItemCollection().containsValue(item) && checkAvailability(item))
        {
        	item.setQuantity(item.getQuantity()+1);
        	return true;
        }
        else if(!itemCollection.containsValue(item))
        {
        	itemCollection.put(item.getItemName(),item);	
        	return true;
        }
        else return false;
    }

    public Item remove(String itemName) {
        if (itemCollection.containsKey(itemName))
        {
        	Item deleted = itemCollection.get(itemName);
        	itemCollection.remove(itemName);
        	return deleted;
        }
        else
        	return null;
    }

    public abstract void display();


	public void setitemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}
    
    
}

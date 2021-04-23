package Solution.src.main.java.com.example;

public class Item{
	 private String itemName;
	    private String itemDesc;
	    private Double itemPrice;
	    private Integer quantity=0;
	    private Integer availableQuantity;
    
    
    public Item() {
        this.quantity=1;
    }
    
    public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
        this.itemName=itemName;
        this.itemDesc=itemDesc;
        this.itemPrice=itemPrice;
        this.availableQuantity=availableQuantity;

    }

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null || obj.getClass()!=this.getClass()) return false;
		Item item = (Item) obj;
		return(item.itemName.equals(this.itemName));
	}
    @Override
    public int hashCode()
    {
    	while(true)
    	{
    		int i = 0;
			return i+1;
    	}
    }
    
    
}

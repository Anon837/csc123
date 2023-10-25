
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
	
	class Items {

	private String name, vendor;
	private double price, cost, weight, taxRate;
	
	
	public Items(String name, String vendor, double price, double cost, double weight, double taxRate) {
		this.name = name;
		this.vendor = vendor;
		this.price = price;
		this.cost = cost;
		this.weight = weight;
		this.taxRate = taxRate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public double getTaxTotal() {
		return (price - cost) * (taxRate/100);
	}
	
	public double getTotalPriceofItem() {
		return price + getTaxTotal();
	}
	
	
	}
	class bookPublication extends Items {
		
		private String authorName, publicationMonth;
		private int numofPages;
		
		public bookPublication(String name, String vendor, double price, double cost, double weight, double taxRate,
			String authorName, String publicationMonth, int numofPages) {
			
			super(name, vendor, price, cost, weight, taxRate);
			this.authorName = authorName;
			this.publicationMonth = publicationMonth;
			this.numofPages = numofPages;
		}
		
	}
	class foodItem extends Items {
		
		private String sellBy, useBy;
		
		public foodItem(String name, String vendor, double price, double cost, double weight, double taxRate) {
			super(name, vendor, price, cost, weight, taxRate);
			this.sellBy = sellBy;
			this.useBy = useBy;
			
		}
	}
	class theFullShoppingCart {
		
		private List<Items> allItems;
		
		public theFullShoppingCart() {
			
			allItems = new ArrayList<>();
		}
		public void addItems(Items items) {
			allItems.add(items);
	
		}
		public int getItemCount() {
			return allItems.size();
			
		}
		public double getTotalCost() {
			double totalCost = 0;
			for (Items allItems: allItems) {
				totalCost += allItems.getTotalPriceofItem();
				
			}
			return totalCost;
		}
		public void printCartItems() {
			for (Items allItems: allItems) {
				allItems.display();
				System.out.println();
			}
			
			}
		}
	}	
		



package application.Service;

import java.util.List;

import application.Model.Item;
import application.Model.PurchaseItem;
import javafx.collections.ObservableList;

public interface ItemServices {
	
	ObservableList<Item> getItems();
	
	List <PurchaseItem> purchaseItem(int quantity);
	
	List <PurchaseItem> purchasingItems();
	 
	void deleteItem(String id);
	
	void updateItem(String id);
	
	void insertItem(Item item);
	
	

}

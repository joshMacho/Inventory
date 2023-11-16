package application.Service;

import java.util.List;

import application.Model.Item;
import application.Model.PurchaseItem;
import javafx.collections.ObservableList;

public interface ItemServices {
	
	ObservableList<Item> getItems();
	
	void purchaseItem(String id, int quantity);
	
	List <PurchaseItem> purchasingList();
	 
	void deleteItem(String id);
	
	void updateItem(String id);
	
	void insertItem(Item item);
	
	

}

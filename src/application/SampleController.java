package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.ImplService.ItemService;
import application.Model.Item;
import application.Service.ItemServices;
import javafx.fxml.Initializable;

public class SampleController implements Initializable{
	
	
	private ItemServices itemService = new ItemService();
	
	
	public List<Item> callList() {
		return itemService.getItems();
	}
	
	public void information() {
		for(Item i: callList()) {
			System.out.print(i.getId()+", "+i.getName()+", "+i.getBrand()+"\n");
		}
	}
	
	public void test() {
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//information();
		test();
	}
}

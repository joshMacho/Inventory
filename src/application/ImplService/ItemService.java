package application.ImplService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.DBConnector;
import application.Model.Item;
import application.Model.PurchaseItem;
import application.Service.ItemServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemService implements ItemServices {
	
	private Connection conn = null;
	private ObservableList<Item> itemList = FXCollections.observableArrayList();
	private List <PurchaseItem> purchaseItem = new ArrayList<PurchaseItem>();
	
	//return list is working fine
	@Override
	public ObservableList<Item> getItems() {
		// TODO Auto-generated method stub
		try {
			conn = DBConnector.dbconnect();
			PreparedStatement ps = conn.prepareStatement("Select * from Items");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				itemList.add(new Item(rs.getString("id"), rs.getString("name"), rs.getString("brand")));
			}
			return itemList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Delete is working fine
	@Override
	public void deleteItem(String id) {
		// TODO Auto-generated method stub
		conn = DBConnector.dbconnect();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from Items where id = ?");
			ps.setString(1, id);
			if(ps.executeUpdate()>0) {
				System.out.println("Succesfully deleted item with id = "+id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//update is working fine
	@Override
	public void updateItem(String id) {
		// TODO Auto-generated method stub
		conn = DBConnector.dbconnect();
		try {
			PreparedStatement ps = conn.prepareStatement("Update Items set name = ?, brand = ? where id = ?");
			ps.setString(1, "SubiDrink");
			ps.setString(2, "Macho");
			ps.setString(3, id);
			if(ps.executeUpdate() > 0) {
				System.out.println("Successfully update item");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		conn = DBConnector.dbconnect();
		try {
			CallableStatement cs = conn.prepareCall("{call addItem(?,?,?)}");
			cs.setString(1, item.getId());
			cs.setString(2, item.getName());
			cs.setString(3, item.getBrand());
			if(cs.executeUpdate() > 0) {
				System.out.println("Successfully inserted "+item.getName());
			}
		}catch(SQLException error) {
			error.printStackTrace();
		}
	}

	@Override
	public void purchaseItem(String id, int quantity) {
		// takes the id of the item, and adds it to the purchasing List.
		conn = DBConnector.dbconnect();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Items WHERE id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				purchaseItem.add(new PurchaseItem(rs.getString("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("sellingPrice"), quantity));
			}
		}catch(SQLException error) {
			error.printStackTrace();
		}
	}

	@Override
	public List<PurchaseItem> purchasingList() {
		// TODO Displays the list of items in the purchasing chamber / list.
		if(purchaseItem.isEmpty()) {
			return null;
		}
		return purchaseItem;
	}

}

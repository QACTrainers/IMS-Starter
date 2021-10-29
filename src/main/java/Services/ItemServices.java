package Services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;

public class ItemServices implements CrudServices<Item> {

	private static Dao<Item> itemDao;
	
	public ItemServices(Dao<Item> ItemDao) {
		ItemServices.itemDao = ItemDao;
	}
	
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	public Item create(Item Item) {
		return itemDao.create(Item);
	}

	public Item update(Item Item) {
		return itemDao.update(Item);
	}

	public void delete(Long item_id) {
		itemDao.delete(item_id);
	}

	@Override
	public Item additems(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Long order_id1) {
		// TODO Auto-generated method stub
		
	}

	
}
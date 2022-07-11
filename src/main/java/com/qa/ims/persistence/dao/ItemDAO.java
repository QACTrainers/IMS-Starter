package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item>{

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Item> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
    }

    public Item readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_ID DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Item read(Long item_ID) {

        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_ID = ?");) {
            statement.setLong(1, item_ID);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Item create(Item item) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("INSERT INTO items(item_name, item_value, quantity, colour) VALUES (?,?,?,?)");) {
            statement.setString(1, item.getItemName());
            statement.setLong(2, item.getItemValue());
            statement.setLong(3, item.getQuantity());
            statement.setString(4, item.getColour());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Item update(Item item) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("UPDATE item SET item_name = ?, item_value = ?, quantity = ?, colour = ? WHERE item_ID = ?");) {
            statement.setString(1, item.getItemName());
            statement.setLong(2, item.getItemValue());
            statement.setLong(3, item.getQuantity());
            statement.setString(4, item.getColour());
            statement.executeUpdate();
            return read(item.getItemID());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(long itemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");) {
            statement.setLong(1, itemID);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long itemID = resultSet.getLong("item_ID");
        String itemName = resultSet.getString("item_name");
        Long itemValue = resultSet.getLong("item_value");
        Long quantity = resultSet.getLong("quantity");
        String colour = resultSet.getString("colour");

        return new Item(itemID, itemName, itemValue, quantity, colour);
    }
}

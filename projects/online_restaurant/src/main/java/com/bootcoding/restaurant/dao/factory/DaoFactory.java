package com.bootcoding.restaurant.dao.factory;

import com.bootcoding.restaurant.common.DatabaseConfiguration;
import com.bootcoding.restaurant.dao.category.CategoryDao;
import com.bootcoding.restaurant.dao.category.CategoryDaoImpl;
import com.bootcoding.restaurant.dao.menu.MenuItemDao;
import com.bootcoding.restaurant.dao.menu.MenuItemDaoImpl;
import com.bootcoding.restaurant.dao.vendor.VendorDao;
import com.bootcoding.restaurant.dao.vendor.VendorDaoImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaoFactory {
    private static DaoFactory daoFactory;
    private VendorDao vendorDao;
    private MenuItemDao menuItemDao;
    private CategoryDao categoryDao;

    private DaoFactory() {

    }

    public static DaoFactory getDAOFactoryInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
            log.info("DAO Factor created!!");
        }
        return daoFactory;
    }

    public VendorDao getVendorDao(DatabaseConfiguration databaseConfiguration) {
        if (vendorDao == null) {
            vendorDao = new VendorDaoImpl(databaseConfiguration);
        }
        return vendorDao;
    }

    public MenuItemDao getMenuItemDao(DatabaseConfiguration databaseConfiguration) {
        if (menuItemDao == null) {
            menuItemDao = new MenuItemDaoImpl(databaseConfiguration);
        }
        return menuItemDao;
    }

    public CategoryDao getCategoryDao(DatabaseConfiguration databaseConfiguration) {
        if (categoryDao == null) {
            categoryDao = new CategoryDaoImpl(databaseConfiguration);
        }
        return categoryDao;
    }

}

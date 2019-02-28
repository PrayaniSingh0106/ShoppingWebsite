package com.dao;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.Accessory;
import com.model.CartObject;

@Repository
public class AccessoryDaoImpl extends JdbcDaoSupport implements AccessoryDao {

	public List<Accessory> getAllAccessories() {
		String sql = "select * from ACCESSORIES_B";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Accessory>(Accessory.class));
	}

	public List<Accessory> getAccessoriesOfType(String itype) {
		String sql = "select * from ACCESSORIES_B where item_type=?";
		return this.getJdbcTemplate().query(sql, new Object[] { itype },
				new BeanPropertyRowMapper<Accessory>(Accessory.class));
	}
	
	public List<String> getAcBrands()
	{
		String sql="select distinct brand from ACCESSORIES_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	public List<String> getAcTypes()
	{
		String sql="select distinct item_type from ACCESSORIES_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	public List<Accessory> getAccessoriesInStock() {
		String sql = "select * from ACCESSORIES_B where stock>0";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Accessory>(Accessory.class));
	}

	public List<Accessory> getAccessoriesInStock(String itype) {
		String sql = "select * from ACCESSORIES_B where item_type=? and stock>0";
		return this.getJdbcTemplate().query(sql, new Object[] { itype },
				new BeanPropertyRowMapper<Accessory>(Accessory.class));
	}

	public int insertAccessory(Accessory a) {
		String sql = "insert into ACCESSORIES_B values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { a.getId(), a.getName(), a.getFrontimage(),
						a.getImage(), a.getImage1(), a.getImage2(),
						a.getImage3(), a.getBrand(), a.getStarrating(),
						a.getItem_type(), a.getPrice(), a.getL1(), a.getL2(),
						a.getL3(), a.getL4(), a.getStock() });
		return 1;
	}

	public int getAccessoryStock(String id) {
		String sql = "select STOCK from ACCESSORIES_B where id=?";
		List<Integer> stocks =this.getJdbcTemplate().queryForList(sql,new Object[] { id }, Integer.class); 
		int stock = 10;
		for (int s : stocks)
			stock = s;
		return stock;
	}

	public int updateAcStock(CartObject myData) {
		String sql = "update ACCESSORIES_B set STOCK = ? where ID=?";
		int oldStock = getAccessoryStock(myData.getId());
		int newStock = oldStock - myData.getQty();
		this.getJdbcTemplate().update(sql,
				new Object[] { newStock, myData.getId() });
		return 1;
	}

	public TreeSet<Accessory> sortAsc(List<Accessory> aclist) {
		TreeSet<Accessory> accSet = new TreeSet<Accessory>(
				new AccessoryComparator());
		for (Accessory a : aclist)
			accSet.add(a);
		return accSet;
	}

	public TreeSet<Accessory> sortDesc(List<Accessory> aclist) {
		TreeSet<Accessory> accSet = new TreeSet<Accessory>(
				new AccessoryDescComparator());
		for (Accessory a : aclist)
			accSet.add(a);
		return accSet;
	}

	public class AccessoryComparator implements Comparator<Accessory> {
		public int compare(Accessory a1, Accessory a2) {
			if (a1.getPrice() > a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public class AccessoryDescComparator implements Comparator<Accessory> {
		public int compare(Accessory a1, Accessory a2) {
			if (a1.getPrice() < a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}

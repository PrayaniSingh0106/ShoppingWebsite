package com.dao;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.CartObject;
import com.model.Laptop;

@Repository
public class LaptopDaoImpl extends JdbcDaoSupport implements LaptopDao {
	
	public List<Laptop> getAllLaptops() {
		System.out.println("Inside laptop dao");
		String sql = "select * from Laptop_B";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Laptop>(Laptop.class));

	}
	
	public List<String> getLBrands()
	{
		String sql="select distinct brand from Laptop_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}
	
	public List<String> getLColor()
	{
		String sql="select distinct color from Laptop_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}
	
	public List<String> getLOpsys()
	{
		String sql="select distinct opSys from Laptop_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	public int insertLaptop(Laptop l) {
		String sql = "insert into Laptop_B values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { l.getId(), l.getName(), l.getFrontimage(),
						l.getImage(), l.getImage1(), l.getImage2(),
						l.getImage3(), l.getBrand(), l.getStarrating(),
						l.getOpSys(), l.getL1(), l.getL2(),
						l.getL3(), l.getL4(),l.getColor(), l.getPrice(), l.getStock() });
		return 1;
	}
	
	public int getLaptopStock(String id) {
		String sql = "select STOCK from LAPTOP_B where id=?";
		List<Integer> stocks = this.getJdbcTemplate().queryForList(sql,new Object[] { id }, Integer.class); 
		int stock = 10;
		for (int s : stocks)
			stock = s;
		return stock;
	}

	public int updateLpStock(CartObject myData) {
		String sql = "update LAPTOP_B set STOCK = ? where ID=?";
		int oldStock = getLaptopStock(myData.getId());
		int newStock = oldStock - myData.getQty();
		this.getJdbcTemplate().update(sql,
				new Object[] { newStock, myData.getId() });
		return 1;
	}

	public List<Laptop> getLaptopInStock() {
		String sql = "select * from Laptop_B where Stock>0";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Laptop>(Laptop.class));
	}
	
	public TreeSet<Laptop> sortAsc(List<Laptop> aclist) {
		TreeSet<Laptop> accSet = new TreeSet<Laptop>(new LaptopComparator());
		for (Laptop a : aclist)
			accSet.add(a);
		return accSet;
	}

	public TreeSet<Laptop> sortDesc(List<Laptop> aclist) {
		TreeSet<Laptop> accSet = new TreeSet<Laptop>(new LaptopDescComparator());
		for (Laptop a : aclist)
			accSet.add(a);
		return accSet;
	}

	public class LaptopComparator implements Comparator<Laptop> {
		public int compare(Laptop a1, Laptop a2) {
			if (a1.getPrice() > a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public class LaptopDescComparator implements Comparator<Laptop> {
		public int compare(Laptop a1, Laptop a2) {
			if (a1.getPrice() < a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}

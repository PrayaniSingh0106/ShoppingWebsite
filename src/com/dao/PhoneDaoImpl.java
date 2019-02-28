package com.dao;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.CartObject;
import com.model.Phone;

@Repository
public class PhoneDaoImpl extends JdbcDaoSupport implements PhoneDao {
	public List<Phone> getAllPhones() {
		String sql = "select * from Phones_B";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Phone>(Phone.class));

	}
	
	public List<String> getPhBrands()
	{
		String sql="select distinct brand from PHONES_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	public List<String> getPhOps()
	{
		String sql="select distinct OPSYS from PHONES_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	public List<String> getPhColors()
	{
		String sql="select distinct color from PHONES_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	
	
	public List<Phone> getInStockPhone() {
		String sql = "Select * from Phones_B where stock>0";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Phone>(Phone.class));
	}

	public int insertPhone(Phone p) {
		String sql = "insert into Phones_B values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { p.getId(), p.getName(), p.getFrontimage(),
						p.getImage(), p.getImage1(), p.getImage2(),
						p.getImage3(), p.getBrand(), p.getStarrating(),
						p.getOpSys(), p.getPrice(), p.getL1(), p.getL2(),
						p.getL3(), p.getL4(), p.getStock(), p.getColor() });
		return 1;
	}
	
	public int getPhoneStock(String id) {
		String sql = "select STOCK from PHONES_B where id=?";
		List<Integer> stocks = this.getJdbcTemplate().queryForList(sql,new Object[] { id }, Integer.class); 
		int stock = 10;
		for (int s : stocks)
			stock = s;
		return stock;
	}

	public int updatePhStock(CartObject myData) {
		String sql = "update PHONES_B set STOCK = ? where ID=?";
		int oldStock = getPhoneStock(myData.getId());
		int newStock = oldStock - myData.getQty();
		this.getJdbcTemplate().update(sql,
				new Object[] { newStock, myData.getId() });
		return 1;
	}

	public TreeSet<Phone> sortAsc(List<Phone> aclist) {
		TreeSet<Phone> accSet = new TreeSet<Phone>(new PhoneComparator());
		for (Phone a : aclist)
			accSet.add(a);
		return accSet;
	}

	public TreeSet<Phone> sortDesc(List<Phone> aclist) {
		TreeSet<Phone> accSet = new TreeSet<Phone>(new PhoneDescComparator());
		for (Phone a : aclist)
			accSet.add(a);
		return accSet;
	}

	public class PhoneComparator implements Comparator<Phone> {
		public int compare(Phone a1, Phone a2) {
			if (a1.getPrice() > a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public class PhoneDescComparator implements Comparator<Phone> {
		public int compare(Phone a1, Phone a2) {
			if (a1.getPrice() < a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}

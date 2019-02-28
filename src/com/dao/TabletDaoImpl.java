package com.dao;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.CartObject;
import com.model.Tablet;

@Repository
public class TabletDaoImpl extends JdbcDaoSupport implements TabletDao{
	public List<Tablet> getAllTablets() {
		String sql = "select * from Tablet_B";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Tablet>(Tablet.class));

	}

	public List<Tablet> getInStockTablet() {
		String sql = "Select * from Tablet where stock>0";
		return this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Tablet>(Tablet.class));
	}

	public int insertTablet(Tablet p) {
		String sql = "insert into Tablet_B values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { p.getId(), p.getName(), p.getFrontimage(),
						p.getImage(), p.getImage1(), p.getImage2(),
						p.getImage3(), p.getBrand(), p.getStarrating(),
						p.getOpSys(), p.getL1(), p.getL2(),
						p.getL3(), p.getL4(),p.getColor(),p.getPrice(), p.getStock() });
		return 1;
	}
	
	public int getTabletStock(String id) {
		String sql = "select STOCK from Tablet_B where id=?";
		List<Integer> stocks = this.getJdbcTemplate().queryForList(sql,new Object[] { id }, Integer.class); 
		int stock = 10;
		for (int s : stocks)
			stock = s;
		return stock;
	}

	public int updateTbStock(CartObject myData) {
		String sql = "update Tablet_B set STOCK = ? where ID=?";
		int oldStock = getTabletStock(myData.getId());
		int newStock = oldStock - myData.getQty();
		this.getJdbcTemplate().update(sql,
				new Object[] { newStock, myData.getId() });
		return 1;
	}

	public TreeSet<Tablet> sortAsc(List<Tablet> aclist) {
		TreeSet<Tablet> accSet = new TreeSet<Tablet>(new TabletComparator());
		for (Tablet a : aclist)
			accSet.add(a);
		return accSet;
	}

	public TreeSet<Tablet> sortDesc(List<Tablet> aclist) {
		TreeSet<Tablet> accSet = new TreeSet<Tablet>(new TabletDescComparator());
		for (Tablet a : aclist)
			accSet.add(a);
		return accSet;
	}

	public class TabletComparator implements Comparator<Tablet> {
		public int compare(Tablet a1, Tablet a2) {
			if (a1.getPrice() > a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public class TabletDescComparator implements Comparator<Tablet> {
		public int compare(Tablet a1, Tablet a2) {
			if (a1.getPrice() < a2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	@Override
	public List<String> getTBrands() {
		// TODO Auto-generated method stub
		String sql="select distinct brand from Tablet_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	@Override
	public List<String> getTColor() {
		// TODO Auto-generated method stub
		String sql="select distinct color from Tablet_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}

	@Override
	public List<String> getTOpsys() {
		// TODO Auto-generated method stub
		String sql="select distinct opSys from Tablet_B";
		List<String> str= this.getJdbcTemplate().queryForList(sql, String.class); 
		for(String s:str)
			System.out.println(s);
		return str;
	}
}

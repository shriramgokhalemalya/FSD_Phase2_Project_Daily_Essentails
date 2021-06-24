package com.shriramgokhale.projectdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shriramgokhale.projectdemo.model.Sales;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

@Transactional
@Repository
public class AppSalesDAO extends JdbcDaoSupport{
	
    @Autowired
    public AppSalesDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
 
	
	public List<Sales> getSales(){
		String query = "SELECT * FROM SALES";
		//List<Sales> sales = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Sales.class));
		List<Sales> sales = this.getJdbcTemplate().query("select id, item, quantity,price from sales", 
				(result, rowNum) -> new Sales(result.getInt("id"), result.getString("item"), 
						result.getString("quantity"),result.getFloat("price")));
		//System.out.println("SalesDAO"+sales);
		return sales;
	}
	
	public Sales getSales(int id){
		
		String sql = "SELECT * FROM SALES WHERE ID = ?";
		Sales sales = (Sales) this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Sales.class));
		//System.out.println("DAO Class"+sales);
		return sales;
		
	}
	
	public void deleteSale(int id) {
		String sql = "DELETE from SALES WHERE id=?";
		this.getJdbcTemplate().update(sql, id);
	}
	
	public void addSale(String item,String quantity, float price) {
		//String sql = ("INSERT INTO sales(Item,Quantity,Price) VALUES(?,?,?)",item,quantity,price);
		//jdbcTemplate.execute(sql);
		this.getJdbcTemplate().update("INSERT INTO sales(Item,Quantity,Price) VALUES(?,?,?)",item,quantity,price);
	}
	
	public void editSale(int id, String item, String quantity, float price) {
		
		//String sql = "UPDATE sales SET Item=?,Quantity=?,Price=? WHERE id=?",item,quantity,price,id);
		this.getJdbcTemplate().update("UPDATE sales SET Item=?,Quantity=?,Price=? WHERE id=?",item,quantity,price,id);
	}
	
}

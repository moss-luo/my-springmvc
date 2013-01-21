package com.isoftstone.luckydraw.common.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitDB {
	private JdbcTemplate jdbcTemplate;
	
	public void execute() {
		createTables();
		initData();
		/**
		try {
			testSql();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
	}

	private void initData() {
		
		String[] str= {"名单数组"};
		
		for (int i = 0; i < str.length; i++) {
			jdbcTemplate.execute(String.format("insert into PERSONS(NAME,STATUS)values('%s',0)",str[i]));
		}

	}

	private void createTables() {
		jdbcTemplate.execute("CREATE TABLE PERSONS(id INTEGER IDENTITY PRIMARY KEY,name CHAR(25),status INTEGER DEFAULT 0)");
	}
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * 测试SQL
	private void testSql() throws Exception{
		 Class.forName("org.hsqldb.jdbcDriver");  
		 Connection conn2 = DriverManager.getConnection("jdbc:hsqldb:mem:luckydraw","sa","");  
        //查询数据  
        PreparedStatement pstmt = conn2.prepareStatement("SELECT * FROM persons");  
        ResultSet rs = pstmt.executeQuery();  
        while(rs.next()) {  
            String s = null;  
            s = rs.getString(1) + "," + rs.getString(2)+ "," + rs.getString(3);  
            System.out.println(s);  
        }  
        System.out.println("select data OK");  
	}
	 **/
}

package com.isoftstone.wissdemo.common;

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
		
	}

	private void initData() {
		for (int i = 0; i < 30; i++) {
			jdbcTemplate.execute(String.format("insert into PERSONS (NAME, AGE, SEX, PHONE, IDENTITY_CARD_NUM, CURR_ADDRESS, COMPANY_NAME, REMARKS)values('person_%s',27,1,'18612315678','430528198911041254','深圳','isoftstone','初始化_%s')", i, i,i));
		}
	}

	private void createTables() {
		jdbcTemplate.execute("CREATE TABLE PERSONS(id INTEGER IDENTITY PRIMARY KEY,name CHAR(25),age INTEGER,sex INTEGER,phone CHAR(25),identity_card_num CHAR(25),curr_address CHAR(255),company_name CHAR(255),remarks CHAR(255))");
	}
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * 测试SQL
	private void testSql() throws Exception{
		 Class.forName("org.hsqldb.jdbcDriver");  
		 Connection conn2 = DriverManager.getConnection("jdbc:hsqldb:mem:wissDemo","sa","");  
        //查询数据  
        PreparedStatement pstmt = conn2.prepareStatement("SELECT * FROM persons");  
        ResultSet rs = pstmt.executeQuery();  
        while(rs.next()) {  
            String s = null;  
            s = rs.getString(1) + "," + rs.getString(2);  
            System.out.println(s);  
        }  
        System.out.println("select data OK");  
	}
	**/
}

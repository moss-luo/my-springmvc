package com.isoftstone.agiledev.hrdemo.dba.internal;

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
			jdbcTemplate.execute(String.format("INSERT INTO USER(name, password,mobile,email) VALUES('User_%s', 'User_%s','13888888888','User_%s@163.com')", i, i,i));
		}
		
		for (int i = 0; i < 30; i++) {
			jdbcTemplate.execute(String.format("insert into PERSONS (NAME, AGE, SEX, PHONE, IDENTITY_CARD_NUM, CURR_ADDRESS, COMPANY_NAME, REMARKS,SCHOOL_ID)values('person_%s',%s,1,'18612315678','430528198911041254','深圳','isoftstone','初始化_%s',%s)", i, 19+i,i,i));
		}
		
		jdbcTemplate.execute("insert into school(school_name,school_address)values('南头中学','南山区南头')");
		for (int i = 0; i < 5; i++) {
			jdbcTemplate.execute(String.format("insert into card(c_i_i,card_name,person_id)values('银行_%s','XX纪念卡%s',0)",i,i));
		}
	}

	private void createTables() {
		jdbcTemplate.execute("CREATE TABLE USER(id IDENTITY PRIMARY KEY, name CHAR(16), password CHAR(32), mobile CHAR(32), email CHAR(32))");
		
		jdbcTemplate.execute("CREATE TABLE PERSONS(id INTEGER IDENTITY PRIMARY KEY,name CHAR(25),age INTEGER,sex INTEGER,phone CHAR(25),identity_card_num CHAR(25),curr_address CHAR(255),company_name CHAR(255),remarks CHAR(255),SCHOOL_ID INTEGER)");
		jdbcTemplate.execute("CREATE TABLE SCHOOL(t_id INTEGER IDENTITY PRIMARY KEY,school_name CHAR(25),school_address CHAR(25))");
		jdbcTemplate.execute("CREATE TABLE CARD(id INTEGER IDENTITY PRIMARY KEY,card_name CHAR(25),person_id INTEGER,c_i_i CHAR(25))");
	}
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
}

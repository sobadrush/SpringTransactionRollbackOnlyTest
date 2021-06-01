package com.roger.springtest;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springContext/application-context-roger.xml");
		DataSource mssqlDS = context.getBean("myMssqlDB", DataSource.class);
		try(Connection conn = mssqlDS.getConnection();) {
			System.out.println(conn.getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		context.close();
	}

}

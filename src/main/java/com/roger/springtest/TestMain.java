package com.roger.springtest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roger.mappers.DeptMapper;
import com.roger.model.DeptVO;

public class TestMain {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springContext/application-context-roger.xml");
//		DataSource mssqlDS = context.getBean("myMssqlDB", DataSource.class);
//		try(Connection conn = mssqlDS.getConnection();) {
//			System.out.println(conn.getMetaData().getDatabaseProductName());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		context.close();
		
		// -----------------------------------------------------------------------------
		// 測試MyBatis
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springContext/application-context-roger.xml");
		DeptMapper deptMapper = context.getBean("deptMapper", DeptMapper.class);
		
//		deptMapper.getAll().stream().forEach(deptVO -> {
//			System.out.println("部門 : " + deptVO);
//		});
		
//		System.out.println(deptMapper.getByPrimaryKey(70));
		
		DeptVO deptVO = new DeptVO();
		// deptVO.setDeptName("研發部");
		deptVO.setDeptLoc("中國上海");
		System.out.println(deptMapper.getByCondition(deptVO));
		
		context.close();
	}

}

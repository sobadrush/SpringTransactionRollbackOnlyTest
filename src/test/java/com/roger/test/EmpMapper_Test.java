package com.roger.test;

import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roger.mappers.EmpMapper;
import com.roger.model.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:springContext/application-context-roger.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
public class EmpMapper_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(" === All Test Start === ");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println(" === All Test Done === ");
	}

	@Rule 
	public TestName testName = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("===============================================================================");
		System.out.println("========================〔START〕【" + testName.getMethodName() + "】〔START〕==========================");
		System.out.println("===============================================================================");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("================================================================================");
		System.out.println("==========================〔END〕【" + testName.getMethodName() + "】〔END〕=============================");
		System.out.println("================================================================================");
	}

	@Autowired
	private EmpMapper empMapper;
	
	@Test
	@Ignore
	@Rollback(true)
	public void test001() {
		Set<EmpVO> emps = empMapper.getAll();
		for (EmpVO empVO : emps) {
			System.out.println("員工: " + empVO);
		}
	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void test002() {
		EmpVO empVO = new EmpVO();
		empVO.setEmpJob("manager");
		empMapper.getByCondition(empVO).forEach( emp -> {
			System.out.println(emp);
		} );
	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void test003() {
		EmpVO empVO = new EmpVO();
		empVO.setEmpNo("E20210601-99");
		empVO.setEmpName("館長");
		empVO.setEmpJob("健身教練");
		empVO.setEmpHiredate(new java.util.Date());
		empVO.setDeptNo("D20210601-03"); // 業務部
		System.out.println("INSERT EMP : " + empMapper.insert(empVO));
	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void test004() {
		System.out.println("DELETE EMP : " + empMapper.delete("E20210601-01"));
	}

}

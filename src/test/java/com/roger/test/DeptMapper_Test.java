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

import com.roger.mappers.DeptMapper;
import com.roger.model.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:springContext/application-context-roger.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = TransactionDefinition.TIMEOUT_DEFAULT, rollbackFor = Exception.class)
public class DeptMapper_Test {

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
	private DeptMapper deptMapper;
	
	@Test
	@Ignore
	@Rollback(true)
	public void test001() {
		Set<DeptVO> depts = deptMapper.getAll();
		for (DeptVO deptVO : depts) {
			System.out.println(" >>> " + deptVO);
		}
	}
	
	@Test
	@Ignore
	@Rollback(true)
	public void test002() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptNo("D20210601-99");
		deptVO.setDeptName("交通部");
		deptVO.setDeptLoc("板橋區");
		System.out.println("INSERT Dept : " + deptMapper.insert(deptVO));
	}

}

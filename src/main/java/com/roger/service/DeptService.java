package com.roger.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roger.mappers.DeptMapper;
import com.roger.mappers.EmpMapper;
import com.roger.model.DeptVO;
import com.roger.model.EmpVO;

@Service
@Transactional
public class DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	@Autowired
	private EmpService empService;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = -1, rollbackFor = Exception.class)
	public int insertDeptAndEmp() {

		System.out.println("============================");
		String empPk = "E20210601-01";
		EmpVO pEmpVO = new EmpVO();
		pEmpVO.setEmpNo(empPk); // ※※※※※※※※※※※※※※※※※※ 故意PK重複
		pEmpVO.setEmpName("館長");
		pEmpVO.setEmpJob("健身教練");
		pEmpVO.setEmpHiredate(new java.util.Date());
		pEmpVO.setDeptNo("D20210601-02"); // 研發部
		System.out.println("============================");
		
		try {
			empService.insertOneEmp(pEmpVO);
		} catch (Exception e) {
			String exceptionName = ExceptionUtils.getStackFrames(e)[0];
			if (exceptionName.contains("DuplicateKeyException")) {
				empMapper.delete(empPk); // STEP 1: 主鍵重複, 先刪除舊的
				empService.insertOneEmp(pEmpVO); // STEP 2: 再INSERT
			}
//			e.printStackTrace();
		}
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptNo("D20210601-99");
		deptVO.setDeptName("國防部");
		deptVO.setDeptLoc("博愛特區");
		return deptMapper.insert(deptVO);
	}
	
}

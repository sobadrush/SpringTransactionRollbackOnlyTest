package com.roger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roger.mappers.EmpMapper;
import com.roger.model.EmpVO;

@Service
@Transactional
public class EmpService {

	@Autowired
	private EmpMapper empMapper;

	// 需修改為 Propagation.NESTED, 才能避免 Transaction rolled back because it has been marked as rollback-only
	@Transactional(propagation = Propagation.NESTED, isolation = Isolation.DEFAULT, timeout = -1, rollbackFor = Exception.class)
	public int insertOneEmp(EmpVO pEmpVO) {
		return empMapper.insert(pEmpVO);
	}
}

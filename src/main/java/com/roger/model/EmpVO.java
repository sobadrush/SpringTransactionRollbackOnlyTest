package com.roger.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empNo; // Column: empno
	private String empName; // Column: ename
	private String empJob; // Column: job
	private java.util.Date empHiredate; // Column: hiredate
	private Integer deptNo;

	public EmpVO() {
		super();
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	
	public java.util.Date getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(java.util.Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}

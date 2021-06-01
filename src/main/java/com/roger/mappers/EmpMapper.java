package com.roger.mappers;

import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.roger.model.EmpVO;


@Mapper
public interface EmpMapper {

	@Results(id = "empRsMap", value = { 
			@Result(property = "empNo", column = "empno"),
			@Result(property = "empName", column = "ename"), 
			@Result(property = "empJob", column = "job"),
			@Result(property = "empHiredate", column = "hiredate"),
			@Result(property = "deptNo", column = "deptno"),
		}
	)
	
	@Select("SELECT * FROM EMP_TB")
	public Set<EmpVO> getAll();
	
	@ResultMap(value = "empRsMap")
	@Select("SELECT * FROM EMP_TB WHERE empno = #{ empId }")
	public EmpVO getByPrimaryKey(@Param("empId") Integer empId);
	
	@ResultMap(value = "empRsMap")
	@Select({
		"<script>",
			"SELECT * FROM EMP_TB",
			"<where>",
				"<if test='paramVO.empNo != null'> AND empno = #{paramVO.empNo} </if>",
				"<if test='paramVO.empName != null'> AND ename = #{paramVO.empName} </if>",
				"<if test='paramVO.empJob != null'> AND job = #{paramVO.empJob} </if>",
				"<if test='paramVO.empHiredate != null'> AND hiredate = #{paramVO.empHiredate} </if>",
			"</where>",
        "</script>"
	})
	public Set<EmpVO> getByCondition(@Param("paramVO") EmpVO empVO);
	
	@Insert({
		"<script>",
			"INSERT INTO emp_TB(ename, job, hiredate, deptno) " + 
			"VALUES(#{ empVO.empName }, #{ empVO.empJob }, #{ empVO.empHiredate }, #{ empVO.deptNo })",
		"</script>"
	})
	public int insert(@Param("empVO") EmpVO empVO);
}


package com.roger.mappers;

import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.roger.model.DeptVO;


@Mapper
public interface DeptMapper {

	@Results(id = "deptRsMap", value = { 
			@Result(property = "deptNo", column = "deptno"),
			@Result(property = "deptName", column = "dname"), 
			@Result(property = "deptLoc", column = "loc")
		}
	)
	
	@Select("SELECT * FROM DEPT_TB")
	public Set<DeptVO> getAll();
	
	@ResultMap(value = "deptRsMap")
	@Select("SELECT * FROM DEPT_TB WHERE deptNo = #{ deptId }")
	public DeptVO getByPrimaryKey(@Param("deptId") Integer deptId);
	
	@ResultMap(value = "deptRsMap")
	@Select({
		"<script>",
			"SELECT * FROM DEPT_TB",
			  "<where>",
			  "    <if test=' paramVO.deptNo != null '>AND deptNo = #{ paramVO.deptNo }</if>", 
			  "    <if test=' paramVO.deptName != null '>AND dname = #{ paramVO.deptName }</if>", 
			  "    <if test=' paramVO.deptLoc != null '>AND loc = #{ paramVO.deptLoc }</if>", 
			  "</where>",
		"</script>"
	})
	public DeptVO getByCondition(@Param("paramVO") DeptVO paramDeptVO);

	@Insert({
		"<script>",
		    "INSERT INTO dept_TB(dname, loc) VALUES( #{paramVO.deptName}, #{paramVO.deptLoc} )",
		"</script>"
	})
	public int insert(@Param("paramVO") DeptVO paramDeptVO);
}


package com.example.demo.mybatis;

public class EmployeeMapper {
	@Select({
	    "select * from employee where name = #{name} limit 1"
	})
	Employee selectByName(String name);
}

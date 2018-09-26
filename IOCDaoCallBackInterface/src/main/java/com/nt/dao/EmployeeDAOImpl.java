package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.BO.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO
{
	private static final String GetEmployeeDetailsByNumber="SELECT EMPNO as eno,ENAME as ename,JOB as job,SAL as salary FROM EMP WHERE EMPNO=?";
	private JdbcTemplate jt;
	 public EmployeeDAOImpl(JdbcTemplate jt)
	 {
		this.jt = jt;
	}
	/*@Override
	public EmployeeBO getEmployeeDetilsByNo(int eno)
	{
		
		EmployeeBO ebo=null;
		ebo=jt.queryForObject(GetEmployeeDetailsByNumber , new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class));
		return ebo;
	}*/
	/*@Override
	public EmployeeBO getEmployeeDetilsByNo(int eno)
	{
		EmployeeBO bo=null;
		bo=jt.queryForObject(GetEmployeeDetailsByNumber, new RowMapper<EmployeeBO>()
				{

					@Override
					public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						EmployeeBO bo=null;
						bo.setEno(rs.getInt(1));
						bo.setEname(rs.getString(2));
						bo.setJob(rs.getString(3));
						bo.setSalary(rs.getInt(4));
		return bo;
	}
				}*/
	 @Override
		public EmployeeBO getEmployeeDetailsByNo(int eno) {
			EmployeeBO bo=null;
			bo=jt.queryForObject(GetEmployeeDetailsByNumber,
					    new RowMapper<EmployeeBO>(){

				@Override
				public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				    EmployeeBO bo=null;
					bo=new EmployeeBO();
					bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSalary(rs.getInt(4));
					return bo;
				}//mapRow(-,-)
			} //anonymous inner class
			,eno);
			
			return bo;
		}
	}

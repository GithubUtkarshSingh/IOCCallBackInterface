package com.nt.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.BO.EmployeeBO;
import com.nt.DTO.EmployeeDTO;
import com.nt.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;
	
	public EmployeeServiceImpl(EmployeeDAO dao)
	{
		this.dao = dao;
	}

	/*@Override
	public EmployeeDTO findEmployeeByNo(int eno) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public EmployeeDTO findEmployeeByNo(int eno) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override*/
	public EmployeeDTO findEmployeeByNo(int eno)
	{
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//Use DAO
		bo=dao.getEmployeeDetailsByNo(eno);
		//Convert BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
		
	}

}

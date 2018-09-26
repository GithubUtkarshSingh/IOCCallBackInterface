package com.nt.Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.DTO.EmployeeDTO;
import com.nt.Service.EmployeeService;

public class EmployeeTest 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
      ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
      service=ctx.getBean("empService",EmployeeService.class);
      try
      {
    	  dto=((EmployeeService) service).findEmployeeByNo(7499);
    	  System.out.println(dto.getEno()+" "+dto.getEname()+" "+dto.getSalary()+" "+dto.getEno());
    	  System.out.println(",,----------------------------------");  
      }
      catch(DataAccessException dae)
      {
    	  dae.printStackTrace();
      }
      ((AbstractApplicationContext) ctx).close();
      
	}

}

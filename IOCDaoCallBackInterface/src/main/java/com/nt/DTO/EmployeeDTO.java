package com.nt.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable 
{
	private int eno;
	private String ename;
	private String job;
	private int salary;

}

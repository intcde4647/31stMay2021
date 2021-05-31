package com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.InvalidIdException;
import com.model.Employee;

import com.util.ConnectionHandler;

public class EmployeeDaoImpl implements EmployeeDao{
	
	public List<Employee> readFromFile()
	{
		BufferedReader br=null;
		List<Employee>employees=new ArrayList<Employee>();
		try
		{
			br=new BufferedReader(new FileReader("./src/employee.txt"));
			String strRec=null;
			//Reading the file line by line
			while((strRec=br.readLine())!=null)
			{
				System.out.println(strRec);
				//Splitting each line into fields on the basis
				//of ',' as the delimiter
				String[]data=strRec.split(",");
				if(data[0].startsWith("cts"))
				{
				    Employee employee=new Employee();
				    employee.setEmpId(data[0]);
				    employee.setName(data[1]);
				    employee.setDesig(data[2]);
				    employee.setDept(data[3]);
				    employee.setBasic(Integer.parseInt(data[4]));
				    float hra=400.40f;
				    employee.setHra(hra);
					employees.add(employee);
				}
				 	
					
				
				else
					try
				     {
					    throw new InvalidIdException("Invalid id exception id should start with CTS");
				     }
				catch(InvalidIdException inv)
				{
					System.out.println(inv.getMessage());
				}
				
					
				
			}
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			try
			{
				
			}
			catch(Exception e) {}
				
		}
		return employees;
	}
	
	public void writeToDatabase(List<Employee> list)
	{
		EmployeeDao pd=new EmployeeDaoImpl();
		String insertString="insert into employee_details3 values(?,?,?,?,?,?)";
		Connection con=ConnectionHandler.getConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(insertString);
			for(Employee  e:list)
			{
				pstmt.setString(1, e.getEmpId());
				pstmt.setString(2, e.getName());
				pstmt.setString(3, e.getDesig());
				pstmt.setString(4, e.getDept());
				pstmt.setInt(5, e.getBasic());
				pstmt.setFloat(6, e.getHra());
				pstmt.executeUpdate();
			}
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				con.close();
			}
			catch(SQLException sql) {}
		}
		
	}

}

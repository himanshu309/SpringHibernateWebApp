package com.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Employee;


@Controller
@RequestMapping(value="/", method=RequestMethod.GET)
public class EmployeeController 
{
	/*@Autowired
	//@Qualifier("empDao")
	EmployeeDaoImpl empDao;
	*/
	
		@Autowired
		private SessionFactory sessionFactory;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String index(HttpServletRequest req) {
		System.out.println("Index called");
		return "error";
 	}
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String add(Employee employee,Model model) throws Exception
	{
		/*System.out.println("add Method called------->"+sessionFactory);
		Class c=Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded"+c.getName().toString());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardcoded","root","");
		String sql="insert into user values (?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, employee.getName());
		pst.setString(2, employee.getPassword());
		pst.setString(3, employee.getEmail());
		pst.setString(4, employee.getGender());
		pst.executeUpdate();
	
		*/
		
		System.out.println("Employee data is here -->"+employee.getEmail()+"    "+employee.getName());
		
		System.out.println("new sessionFactory ------->"+sessionFactory);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		//sessionFactory.close();
		System.out.println("Done---->");
			return "welcome"; 
	}
	@RequestMapping("/Listall")
	public String list(Employee e,Model m)
	{
		/*
		@SuppressWarnings("unchecked")
		 public List<Employee> listEmployeess() {
		  return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		 }
		*/
		
		
		Session session=sessionFactory.openSession();
		Query qry=session.createQuery("from Employee");
		List list=qry.list();
		m.addAttribute("list",list);
		
		return "display";
		
	}
	
	@RequestMapping(value="/delete")
	public void delete(String email)
	{
		
		Session session=sessionFactory.openSession();
		Employee emp=(Employee)session.get(Employee.class, email);
		Transaction tx=session.beginTransaction();
		System.out.println("Delete emp id----------->"+emp);
		session.delete(emp);
		tx.commit();
		
				
}
	@RequestMapping(value="/edit")
		public String edit(String email,String name,String passowrd)
		{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Employee emp=session.get(Employee.class, email);
			emp.setName(name);
			emp.setPassword(passowrd);
			session.saveOrUpdate(emp);
			tx.commit();
					
			return "update";
		}
	
}
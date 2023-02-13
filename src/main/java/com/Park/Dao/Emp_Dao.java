package com.Park.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Park.Bo.Staff_bo;
import com.Park.Bo.Vis_bo;






public class Emp_Dao {
	
	public static Connection getConnection() {
		Connection con =null;
		String url = "jdbc:mysql://localhost:3306/parkmanagement";
		String user = "root";
		String pwd = "Sng@3267";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			System.out.println(e);

		}
		return con;
	}
	
	public static boolean userLogin(String email, String pwd) {
		boolean status = false;

		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = Emp_Dao.getConnection();
			String sql = "select email,password from admin where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}
	
	public static boolean VisLogin(String email, String pwd) {
		boolean status = false;

		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = Emp_Dao.getConnection();
			String sql = "select email,password from visitors where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			System.out.println(status);   //debugging

		} catch (Exception e) {

			System.out.println(e);
		}

		return status;

	}
	
	public static int signup(Vis_bo em) {
		int status = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		}
		Connection con = Emp_Dao.getConnection();
		String sql = "insert into visitors(name,email,phone,password,age,enq) values (?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, em.getName());
			st.setString(2, em.getEmail());
			st.setString(3, em.getPhone());
			st.setString(4, em.getPass());
			st.setString(5,em.getAge());
			st.setString(6, em.getEnq());
			
			status = st.executeUpdate();
		} catch (SQLException e) {

			System.out.println(e);
		}

		return status;

	}
	
	
	
	public static int addEmp( Staff_bo obj) {
		int status=0;
		try {
			Connection con;
			con=getConnection();
			if(con==null) {
				System.out.println("Connection Failed");
			}
			else {
				String sql="insert into employee(name, phone, email, job, doj, doc) values(?,?,?,?,?,?)";
				PreparedStatement pr=con.prepareStatement(sql);
				pr.setString(1, obj.getName());
				pr.setString(2, obj.getPhone());
				pr.setString(3, obj.getEmail());
				pr.setString(4, obj.getJob());
				pr.setString(5, obj.getDoj());
				pr.setString(6, obj.getDoc());
				
			status	=pr.executeUpdate();
				//status=rs.next();
//				"insert into employee(name,phone,adhar,DOB,Job,Join_Date) values(?,?,?,?,?,?);";/
			}
		
			}
		catch(Exception c) {
			c.printStackTrace();
		}
		return status;
	}
	
//	public static Staff_bo view() {
//		Staff_bo obj=new Staff_bo();
//		Connection con = getConnection();
//		String sql = "select * from card_details where id=1;";
//
//		try {
//			PreparedStatement st = con.prepareStatement(sql);
//			
//			ResultSet rs=st.executeQuery();
//			while (rs.next()) {
//
//				obj.setId(rs.getInt(1));
//				obj.setName(rs.getString(2));
//				obj.setPhone(rs.getString(3));
//				obj.setEmail(rs.getString(4));
//				obj.setJob(rs.getString(5));
//				obj.setDoj(rs.getString(6));
//				obj.setDoc(rs.getString(7));
//				
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return obj;
//	}
//	
	
	public static List AllEmployee() {

		List<Staff_bo> list = new ArrayList<Staff_bo>();
		try {
			Connection con = Emp_Dao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Staff_bo obj = new Staff_bo();

				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhone(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setJob(rs.getString(5));
				obj.setDoj(rs.getString(6));
				obj.setDoc(rs.getString(7));
				
				list.add(obj);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;

	}
	
public static Staff_bo getEmployeeById(int id) {
		
	Staff_bo eb=new Staff_bo();
		try {
			Connection con =Emp_Dao.getConnection();
			String query="select * from employee where id=?";
			
			PreparedStatement  ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setPhone(rs.getString(3));
				eb.setEmail(rs.getString(4));
				eb.setJob(rs.getString(5));
				eb.setDoj(rs.getString(6));
				eb.setDoc(rs.getString(7));
				System.out.println(eb.getPhone());
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return eb;
	}

public static int Delete(int i) {
int status =0;
try {
	Connection con =Emp_Dao.getConnection();
	String query="delete from employee where id=?";
	PreparedStatement  ps=con.prepareStatement(query);

ps.setInt( 1, i);
status =ps.executeUpdate();
	
} catch (Exception e) {
System.out.println(e);
}

return status;
}
public static int Edit(Staff_bo eb) {
int status =0;
try {
	Connection con =Emp_Dao.getConnection();
	String query="update employee set name=?,phone=?,email=?,job=?,doj=?,doc=? where id=?";
	PreparedStatement  ps=con.prepareStatement(query);
	ps.setString(1, eb.getName());
	ps.setString(2, eb.getPhone());
	ps.setString(3, eb.getEmail());
	ps.setString(4, eb.getJob());
	ps.setString(5, eb.getDoj());
	ps.setString(6, eb.getDoc());
	ps.setInt(7, eb.getId());
	
	status=ps.executeUpdate();

	
} catch (Exception e) {
System.out.println(e);
}

return status;
}


}

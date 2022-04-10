package controller;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import models.Department;

@ManagedBean(name = "departmentBean")
@SessionScoped
public class DepartmentBean implements Serializable {

    public DepartmentBean() {
    }
    
    private final String url = "jdbc:postgresql://localhost:5432/postgres";

    private final String username = "postgres";
    
    private final String password = "12345678";
    
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    
    private Connection connect;
    
    private final Department department = new Department();
    
    public Department getDepartment() {
        return this.department;
    }

    public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<Department> departments = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select id, name, semester_price, students_number from departments");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getLong("id"));
            department.setName(rs.getString("name"));
            department.setPrice(rs.getBigDecimal("semester_price"));
            department.setStudentsNumber(rs.getInt("students_number"));
            
            departments.add(department);
        }

        rs.close();
        pstmt.close();
        connect.close();

        return departments;
    }
    
    public String edit(int id) throws ClassNotFoundException {  
        try {
            Class.forName("org.postgresql.Driver");

            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }
        
        try {
            Statement stmt = connect.createStatement();
            ResultSet rs=stmt.executeQuery("select * from departments where id = " + (id));  
            rs.next();  
            Department department = new Department();  
            department.setId(rs.getLong("id"));  
            department.setName(rs.getString("name"));  
            department.setPrice(rs.getBigDecimal("semester_price"));  
            department.setStudentsNumber(rs.getInt("students_number"));
            
            sessionMap.put("editDepartment", department);  
            connect.close();  
        } catch(Exception e){  
            System.out.println(e);  
        }         
        return "/department/edit.xhtml?faces-redirect=true";  
    }
    
    public void delete(long id){  
        try {
            try {
                Class.forName("org.postgresql.Driver");

                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("in exec");
                System.out.println(ex.getMessage());
            }
            
            PreparedStatement stmt = connect.prepareStatement("delete from departments where id = " + id);    
            stmt.executeUpdate();    
        } catch(Exception e){  
            System.out.println(e);  
        }  
    }  
    
    public String save(){  
        int result = 0;  
        
        try {  
            try {
                Class.forName("org.postgresql.Driver");

                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("in exec");
                System.out.println(ex.getMessage());
            }
            PreparedStatement stmt = connect.prepareStatement("insert into departments (name, semester_price, students_number) values(?,?,?)");  
            stmt.setString(1, department.getName());
            stmt.setBigDecimal(2, department.getPrice());
            stmt.setInt(3, department.getStudentsNumber());
            result = stmt.executeUpdate();  
            connect.close();  
        } catch (Exception e){  
            System.out.println(e);  
        }  
        if (result !=0)  
            return "/department/index.xhtml?faces-redirect=true";  
        else return "/department/create.xhtml?faces-redirect=true";  
    }
    
    public String update(Department d){
        try {  
            try {
                Class.forName("org.postgresql.Driver");

                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("in exec");
                System.out.println(ex.getMessage());
            }    
            PreparedStatement stmt = connect.prepareStatement("update departments set name=?,semester_price=?,students_number=? where id=?");    
            stmt.setString(1, d.getName());
            stmt.setBigDecimal(2, d.getPrice());
            stmt.setInt(3, d.getStudentsNumber());
            stmt.setLong(4,d.getId());    
            stmt.executeUpdate();  
            connect.close();  
        } catch(Exception e){  
            System.out.println();  
        }  
        return "/department/index.xhtml?faces-redirect=true";        
    }  
}

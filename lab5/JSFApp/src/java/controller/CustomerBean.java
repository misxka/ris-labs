package controller;

import javax.enterprise.context.SessionScoped;
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
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import models.Customer;

@ManagedBean(name = "customerBean")
@SessionScoped
public class CustomerBean implements Serializable {
    
    private final String url = "jdbc:postgresql://localhost:5432/postgres";

    private final String username = "postgres";
    
    private final String password = "12345678";
    
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    
    private Connection connect;
    
    private final Customer customer = new Customer();
    
    public Customer getCustomer() {
        return this.customer;
    }

//    private static final long serialVersionUID = 6081417964063918994L;

    public List<Customer> getCustomers() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<Customer> customers = new ArrayList<>();
        PreparedStatement pstmt = connect.prepareStatement("select customer_id, discount_code, zip, name, addressline1, addressline2, city, state, credit_limit from customer");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setName(rs.getString("name"));
            customer.setDiscountCode(rs.getString("discount_code"));
            customer.setZip(rs.getString("zip"));
            customer.setAddressline1(rs.getString("addressline1"));
            customer.setAddressline2(rs.getString("addressline2"));
            customer.setCity(rs.getString("city"));
            customer.setState(rs.getString("state"));
            customer.setCreditLimit(BigInteger.valueOf(rs.getInt("credit_limit")));
            
            customers.add(customer);
        }

        rs.close();
        pstmt.close();
        connect.close();

        return customers;
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
            ResultSet rs=stmt.executeQuery("select * from customer where customer_id = " + (id));  
            rs.next();  
            Customer customer = new Customer();  
            customer.setCustomerId(rs.getInt("customer_id"));  
            customer.setName(rs.getString("name"));  
            customer.setDiscountCode(rs.getString("discount_code"));  
            customer.setZip(rs.getString("zip"));
            customer.setAddressline1(rs.getString("addressline1"));
            customer.setAddressline2(rs.getString("addressline2"));
            customer.setCity(rs.getString("city"));
            customer.setState(rs.getString("state"));
            customer.setCreditLimit(BigInteger.valueOf(rs.getInt("credit_limit")));
            
            sessionMap.put("editCustomer", customer);  
            connect.close();  
        } catch(Exception e){  
            System.out.println(e);  
        }         
        return "/edit.xhtml?faces-redirect=true";  
    }
    
    public void delete(int id){  
        try {  
            try {
                Class.forName("org.postgresql.Driver");

                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("in exec");
                System.out.println(ex.getMessage());
            }
            
            PreparedStatement stmt = connect.prepareStatement("delete from customer where customer_id = " + id);    
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
            PreparedStatement stmt = connect.prepareStatement("insert into customer (name, zip, discount_code, addressline1, addressline2, city, state, credit_limit) values(?,?,?,?,?,?,?,?)");  
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getZip());
            stmt.setString(3, customer.getDiscountCode());
            stmt.setString(4, customer.getAddressline1());
            stmt.setString(5, customer.getAddressline2());
            stmt.setString(6, customer.getCity());
            stmt.setString(7, customer.getState());
            stmt.setInt(8, customer.getCreditLimit().intValue());
            result = stmt.executeUpdate();  
            connect.close();  
        } catch (Exception e){  
            System.out.println(e);  
        }  
        if (result !=0)  
            return "index.xhtml?faces-redirect=true";  
        else return "create.xhtml?faces-redirect=true";  
    }
    
    public String update(Customer c){
        try {  
            try {
                Class.forName("org.postgresql.Driver");

                connect = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("in exec");
                System.out.println(ex.getMessage());
            }    
            PreparedStatement stmt = connect.prepareStatement(  
            "update customer set name=?,zip=?,discount_code=?,addressline1=?,addressline2=?,city=?,state=?,credit_limit=? where customer_id=?");    
            stmt.setString(1,c.getName());    
            stmt.setString(2,c.getZip());    
            stmt.setString(3,c.getDiscountCode());    
            stmt.setString(4,c.getAddressline1());    
            stmt.setString(5,c.getAddressline2());
            stmt.setString(6,c.getCity());    
            stmt.setString(7,c.getState());    
            stmt.setInt(8,c.getCreditLimit().intValue()); 
            stmt.setInt(9,c.getCustomerId());    
            stmt.executeUpdate();  
            connect.close();  
        } catch(Exception e){  
            System.out.println();  
        }  
        return "/index.xhtml?faces-redirect=true";        
    }  
}

package com.example.lab3.servlets;

import com.example.lab3.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

@WebServlet(name = "customerDetails", value = "/customer-details")
public class CustomerDetails extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int customerNumber = Integer.parseInt(request.getParameter("customer-id"));

            EntityManager em = emf.createEntityManager();
            Customer result = em.find(Customer.class, customerNumber);

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");

            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\">");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
            out.println("</head>");

            out.println("<body>");
            out.println("<div class=\"wrapper\">");

            if(result != null) {
                out.println("<div class=\"alert alert-success\" role=\"alert\">\n" +
                        "Customer's info for №" + customerNumber + ":" +
                        "</div>");
                out.println("<table class=\"table\">");
                out.println("<thead>" +
                        "    <tr>" +
                        "      <th scope=\"col\">Name</th>" +
                        "      <th scope=\"col\">State</th>" +
                        "      <th scope=\"col\">Credit limit</th>" +
                        "    </tr>" +
                        "  </thead>"
                );
                out.println("<tbody>");

                out.println("<tr>" +
                        "      <td>" + result.getName() + "</td>" +
                        "      <td>" + result.getState() + "</td>" +
                        "      <td>" + result.getCreditLimit() + " $" + "</td>" +
                        "    </tr>");

                out.println("</tbody>");
                out.println("</table>");
            }
            else {
                out.println("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                        "Customer not found." +
                        "</div>");
            }

            out.println("</div>");
            out.println("</body>");

            out.println("</html>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
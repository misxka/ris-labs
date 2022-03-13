package com.viaryha.servlet;

import com.viaryha.ejb.DepartmentHandlerLocal;
import com.viaryha.ejb.entities.Department;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/departments")
public class DepartmentServlet extends HttpServlet {
    @EJB
    private DepartmentHandlerLocal departmentHandler;

    @PersistenceUnit
    EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            EntityManager em = emf.createEntityManager();
            List<Department> results = em.createQuery("SELECT d FROM Department d ORDER BY d.studentsNumber ASC", Department.class)
                .setMaxResults(2)
                .getResultList();

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");

            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\">");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
            out.println("</head>");

            out.println("<body>");
            out.println("<div class=\"wrapper\">");
            out.println("<table class=\"table\">");
            out.println("<thead>" +
                "    <tr>" +
                "      <th scope=\"col\">Факультет</th>" +
                "      <th scope=\"col\">Количество студентов</th>" +
                "      <th scope=\"col\">Плата за семестр</th>" +
                "    </tr>" +
                "  </thead>"
            );
            out.println("<tbody>");

            results.forEach(result -> {
                out.println("<tr>" +
                    "      <td>" + result.getName() + "</td>" +
                    "      <td>" + result.getStudentsNumber() + "</td>" +
                    "      <td>" + result.getPrice() + "</td>" +
                    "    </tr>");
            });

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");

            out.println("</html>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String departmentId = request.getParameter("department-id");
            int semestersAmount = Integer.parseInt(request.getParameter("semesters-amount"));

            EntityManager em = emf.createEntityManager();
            Department department = em.createQuery("SELECT d FROM Department d WHERE d.id = '" + departmentId + "'" , Department.class).getSingleResult();
            BigDecimal totalPrice = department.getPrice().multiply(BigDecimal.valueOf(semestersAmount));

            String semesterStr;
            if (semestersAmount == 1) semesterStr = "семестр";
            else if (semestersAmount < 5) semesterStr = "семестра";
            else semesterStr = "семестров";

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");

            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\">");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
            out.println("</head>");

            out.println("<body>");
            out.println("<div class=\"wrapper\">");

            out.println("<h3>" + department.getName() + "</h3>");
            out.println("<h3>Стоимость обучения за " + semestersAmount + " " + semesterStr + " " + " составит: " + totalPrice + " бел. рублей</h3>");
            out.println("</div>");
            out.println("</body>");

            out.println("</html>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

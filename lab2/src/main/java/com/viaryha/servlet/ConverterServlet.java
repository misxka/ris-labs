package com.viaryha.servlet;

import com.viaryha.ejb.ConverterLocal;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "ConverterServlet", value = "/ConverterServlet")
public class ConverterServlet extends HttpServlet {
    @EJB
    private ConverterLocal converter;

    @PersistenceUnit
    EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String amount = request.getParameter("amount");
            if (amount != null && amount.length() > 0) {
                BigDecimal d = new BigDecimal(amount);
                BigDecimal yenAmount = converter.dollarToYen(d);
                BigDecimal euroAmount = converter.yenToEuro(yenAmount);

                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Конвертер валют</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Сумма в долларах = " + d + "</p>");
                out.println("<p>Сумма в йенах = " + yenAmount + "</p>");
                out.println("<p>Сумма в евро = " + euroAmount + "</p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

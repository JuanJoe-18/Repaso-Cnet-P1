package com.icesi.web;

import com.icesi.model.Measurement;
import com.icesi.service.IMeasurementService;
import com.icesi.service.impl.MeasurementServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/measurements")
public class MeasurementServlet extends HttpServlet {
    private IMeasurementService service;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = context.getBean(IMeasurementService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("measurements", service.list());
        request.getRequestDispatcher("/measurements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Measurement m = new Measurement(  Integer.parseInt(request.getParameter("id")), Long.parseLong(request.getParameter("timestamp")),  Double.parseDouble(request.getParameter("valor")), Integer.parseInt(request.getParameter("assetId")));
            service.add(m);
            response.sendRedirect(request.getContextPath() + "/measurements");
        } catch (IllegalArgumentException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
        }
    }
}

package com.icesi.web;

import com.icesi.model.Device;
import com.icesi.service.IDeviceService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/devices")
public class DeviceServlet extends HttpServlet {
    private IDeviceService service;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        service = context.getBean(IDeviceService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Device device = service.findById(id);
            request.setAttribute("deviceToEdit", device);
        }
        request.setAttribute("devices", service.list());
        request.getRequestDispatcher("/devices.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "create";
        }
        
        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                service.delete(id);
            } else {
                Device device = new Device( Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("serialNumber"), request.getParameter("type"), Double.parseDouble(request.getParameter("maxValue")), Double.parseDouble(request.getParameter("minValue")), Long.parseLong(request.getParameter("samplingPeriod")), Long.parseLong(request.getParameter("timeTolerance")), request.getParameter("unit"), request.getParameter("ubicacion"), request.getParameter("estate"));
                
                if ("update".equals(action)) {
                    service.update(device);
                } else {
                    service.add(device);
                }
            }
            response.sendRedirect(request.getContextPath() + "/devices");
        } catch (IllegalArgumentException ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
        }
    }
}

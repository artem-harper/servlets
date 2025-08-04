package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.FlightService;
import org.example.util.JspHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flights", flightService.findAll());
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        req.getRequestDispatcher(JspHelper.getPath("flights")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var name = req.getParameter("name");
    }
}

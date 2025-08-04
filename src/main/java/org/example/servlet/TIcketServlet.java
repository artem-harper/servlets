package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.TicketService;
import org.example.util.JspHelper;

import java.io.IOException;

@WebServlet("/tickets")
public class TIcketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var params = Long.valueOf(req.getParameter("flightId"));
        req.setAttribute("tickets", ticketService.findTicketsByFlightId(params));

        req.getRequestDispatcher(JspHelper.getPath("tickets"))
                .forward(req, resp);
    }
}

package hei.tp03.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hei.tp03.entity.Client;
import hei.tp03.service.ClientService;
import javafx.print.Printer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name="ClientServlet", urlPatterns = {"/*"})
public class ClientServlet  extends HttpServlet {

    private ClientService clientService;

    private ConfigurableApplicationContext context;

    @Override
    public void init()
    {
        context = new AnnotationConfigApplicationContext("hei.tp03.config");
        clientService = (ClientService) context.getBean(ClientService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Client> listeClients = clientService.findAll();
        resp.setHeader("Content-Type","application/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonAAfficher = mapper.writeValueAsString(listeClients);
        resp.getWriter().println(jsonAAfficher);
    }

    @Override
    public void destroy(){
        context.close();
    }
}

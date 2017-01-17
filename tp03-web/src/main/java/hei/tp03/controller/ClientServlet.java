package hei.tp03.controller;

import hei.tp03.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientServlet  extends HttpServlet {

    private ConfigurableApplicationContext context;

    @Override
    public void init()
    {
        ApplicationContext applicationContext = new ClassPathBeanDefinitionScanner()
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){}

    @Override
    public void destroy(){}
}

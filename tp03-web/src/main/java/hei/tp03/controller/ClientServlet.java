package hei.tp03.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import hei.tp03.entity.Client;
import hei.tp03.entity.Commande;
import hei.tp03.entity.Produit;
import hei.tp03.service.ClientService;
import hei.tp03.service.CommandeService;
import hei.tp03.service.ProduitService;
import javafx.print.Printer;
import org.hibernate.Hibernate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="ClientServlet", urlPatterns = {"/*"})
public class ClientServlet  extends HttpServlet {

    private ClientService clientService;

    private CommandeService commandeService;

    private ProduitService produitService;

    private ConfigurableApplicationContext context;

    @Override
    public void init()
    {
        context = new AnnotationConfigApplicationContext("hei.tp03.config");
        clientService = (ClientService) context.getBean(ClientService.class);

        commandeService = (CommandeService) context.getBean(CommandeService.class);

        produitService = (ProduitService) context.getBean(ProduitService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Client> listeClients = clientService.findAll();

        //J'abandonne l'affichage sous forme de JSON,
        // je n'arrive pas à charger les Listes de commandes et de produits
        // sans passer par Fetch = FetchType.EAGER
        // J'ai essayé avec if(!Hibernate.isInitialized())
        //                      Hibernate.initialize();
        // Sans succès. J'ai une brouette de questions pour le prochain cours.

        /*
        resp.setHeader("Content-Type","application/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonAAfficher = mapper.writeValueAsString(listeClients);
        resp.getWriter().println(jsonAAfficher);
        */

        PrintWriter out = resp.getWriter();
        for (Client client:listeClients) {
            out.println("Client: "+client.getId()+" - "+client.getNom()+" "+client.getPrenom());
            List<Commande> listeCommandes = commandeService.findByClientId(client.getId());
            for (Commande commande:listeCommandes) {
                out.println("\n\tCommande: "+commande.getId()+" - Validée "+commande.getValidee());
                List<Produit> listeProduits = produitService.findByCommandeId(commande.getId());
                for (Produit produit: listeProduits) {
                    out.println("\n\t\tProduit: "+produit.getId()+" - "+produit.getNom());
                }
            }
            out.println("\n");
        }


    }

    @Override
    public void destroy(){
        context.close();
    }
}

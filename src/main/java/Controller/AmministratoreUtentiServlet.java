package Controller;

import Model.Utente;
import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AmministratoreUtentiServlet", value = "/amministratore_utenti_servlet")
public class AmministratoreUtentiServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Utente u=(Utente) request.getSession().getAttribute("utente");
      if(u==null||!u.getAdmin()){
        throw new Controller.ServletException("Utente non autorizzato");
      }
      UtenteDAO dao=new UtenteDAO();
      ArrayList<Utente> utenti= (ArrayList<Utente>) dao.doRetrieveAll();
      request.setAttribute("utenti",utenti);

      RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/amministratoreUtenti.jsp");
      dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

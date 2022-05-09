package Controller;

import Model.Utente;
import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistraUtenteServlet", value = "/registra_utente_servlet")
public class RegistraUtenteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession().getAttribute("utente") != null) {
      throw new Controller.ServletException("Utente loggato");
    }
    UtenteDAO dao=new UtenteDAO();
    String username = request.getParameter("username");
    if (!(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$"))) {
      throw new Controller.ServletException("Username non valido.");
    }

    String password = request.getParameter("password");
    if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
        && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
      throw new Controller.ServletException("Password non valida.");
    }

    String passwordConferma = request.getParameter("passwordConferma");
    if (!password.equals(passwordConferma)) {
      throw new Controller.ServletException("Password e conferma differenti.");
    }

    String nome = request.getParameter("nome");
    if (!(nome != null && nome.trim().length() > 0 && nome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      throw new Controller.ServletException("Nome non valido.");
    }

    String cognome = request.getParameter("cognome");
    if (!(cognome != null && cognome.trim().length() > 0 && cognome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      throw new Controller.ServletException("Cognome non valido.");
    }

    String email = request.getParameter("email");
    if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {
      throw new Controller.ServletException("Email non valida.");
    }

    String citta = request.getParameter("citta");
    if (!(citta != null && citta.trim().length() > 0 && citta.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      throw new Controller.ServletException("Citta non valido.");
    }

    String via = request.getParameter("via");
    if (!(via != null && via.trim().length() > 0 && via.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      throw new Controller.ServletException("Via non valido.");
    }

    String prov = request.getParameter("prov");
    if (!(prov != null && prov.trim().length() > 0 && prov.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      throw new Controller.ServletException("Provincia non valido.");
    }

    String cap = request.getParameter("cap");
    if (!(cap != null && cap.trim().length() == 5 && cap.matches("^\\d{5}"))) {
      throw new Controller.ServletException("Cap non valido.");
    }

    int nciv = Integer.parseInt(request.getParameter("nc"));
    String data = request.getParameter("ddn");
    String sex = request.getParameter("sex");

    Utente utente = new Utente();
    utente.setUsername(username);
    utente.setPassword(password);
    utente.setNome(nome);
    utente.setCognome(cognome);
    utente.setEmail(email);
    utente.setVia(via);
    utente.setCitta(citta);
    utente.setProvincia(prov);
    utente.setCAP(cap);
    utente.setnCivico(nciv);
    utente.setDataDiNascita(data);
    utente.setSesso(sex);
    utente.setAdmin(false);

    dao.doSave(utente);
    request.getSession().setAttribute("utente", utente);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/profiloUtente.jsp");
    requestDispatcher.forward(request, response);


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

package Controller;

import Model.Carrello;
import Model.CarrelloDAO;
import Model.OrdineDAO;
import Model.Utente;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@WebServlet(name = "AcquistoServlet", value = "/acquisto_servlet")
public class AcquistoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String prezzo = request.getParameter("prezzoTot");
    Utente u = (Utente) request.getSession().getAttribute("utente");

    if (u == null) {
      throw new Controller.ServletException("Per effettuare l'acquisto devi prima accedere o registrarti");
    }
    CarrelloDAO carrelloDAO=new CarrelloDAO();

    if (prezzo != null) {
      OrdineDAO dao = new OrdineDAO();
      float prezz = Float.parseFloat(prezzo);
      String data = Timestamp.from(Instant.now()).toString();
      Carrello car = carrelloDAO.doRetrieveByUtente(u.getId());
      ArrayList<Integer> idCellulari = new ArrayList<>();
      for (Carrello.CellulareQuantita c : car.getcellulariArray()) {
        idCellulari.add(c.getCellulare().getId());
      }
      dao.doSave(u.getId(), data, prezz, idCellulari);
      carrelloDAO.doDeleteAll(u.getId());
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ordine.jsp");
      dispatcher.forward(request, response);
    } else {
      String dest = request.getHeader("referer");
      if (dest == null || dest.contains("/acquisto_servlet") || dest.trim().isEmpty()) {
        dest = ".";
      }
      response.sendRedirect(dest);
    }
  }

  @Override
  protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
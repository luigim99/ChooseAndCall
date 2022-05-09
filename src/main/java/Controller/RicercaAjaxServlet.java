package Controller;

import Model.Cellulare;
import Model.CellulareDAO;

import org.json.JSONArray;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RicercaAjaxServlet", value = "/ricerca_ajax_servlet")
public class RicercaAjaxServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    JSONArray prodJson = new JSONArray();
    String query = request.getParameter("cellulare");
    CellulareDAO dao=new CellulareDAO();
    if(query != null) {
      ArrayList<Cellulare> cellulari = dao.doRetrieveByNomeOrMarca(query);     //l'asterisco indica che ci possono essere altre lettere dopo query
      for(Cellulare c:cellulari){   //creiamo array JSON, in cui salviamo i nomi di tutti i prodotti conformi alla ricerca
        prodJson.put(c.getNome());
      }
    }
    response.setContentType("application/json");
    response.getWriter().append(prodJson.toString());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

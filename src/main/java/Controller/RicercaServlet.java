package Controller;

import Model.Cellulare;
import Model.CellulareDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RicercaServlet", value = "/ricerca_servlet")
public class RicercaServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String parolaCercata=request.getParameter("query");
    if(parolaCercata!=null){
      if (parolaCercata.equals("")){
        throw new Controller.ServletException("Non hai inserito nessuna parola");
      }
      CellulareDAO dao=new CellulareDAO();
      ArrayList<Cellulare> cellulari=dao.doRetrieveByNomeOrMarca(parolaCercata);
      request.setAttribute("parolaCercata",parolaCercata);
      request.setAttribute("cellulari",cellulari);
    }else{
      CellulareDAO dao=new CellulareDAO();
      Float prezzo=Float.parseFloat(request.getParameter("prezzo"));
      Float schermo=Float.parseFloat(request.getParameter("schermo"));
      int ram=Integer.parseInt(request.getParameter("ram"));
      int memoria=Integer.parseInt(request.getParameter("memoria"));
      int fotocamera=Integer.parseInt(request.getParameter("fotocamera"));
      int batteria=Integer.parseInt(request.getParameter("batteria"));
      String ordine=request.getParameter("ordine");
      boolean asc;
      if(ordine.equalsIgnoreCase("ASC"))
        asc=true;
      else
        asc=false;
      ArrayList<Cellulare> cellulari=  dao.doRetrieveByFiltri(schermo,ram,memoria,fotocamera,batteria,prezzo,asc);
      request.setAttribute("cellulari",cellulari);
    }

    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/ricerca.jsp");
    dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

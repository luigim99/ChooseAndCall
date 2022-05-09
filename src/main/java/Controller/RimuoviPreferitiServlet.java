package Controller;

import Model.Cellulare;
import Model.CellulareDAO;
import Model.PreferitiDAO;
import Model.Utente;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RimuoviPreferitiServlet", value = "/rimuovi_preferiti_servlet")
public class RimuoviPreferitiServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Utente utente=(Utente) request.getSession().getAttribute("utente");
    if(utente==null){
      throw new Controller.ServletException("Utente non loggato. Per accedere alla WishList fai il login o registrati.");
    }

    int codiceUtente=utente.getId();
    PreferitiDAO preferitiDAO=new PreferitiDAO();
    CellulareDAO dao=new CellulareDAO();
    if(request.getParameter("svuota")!=null){
      preferitiDAO.doDeleteAll(codiceUtente);
    }
    else{
      String codString= request.getParameter("idCellulare");
      int codiceCellulare=Integer.parseInt(codString);
      preferitiDAO.doDeleteLista(codiceCellulare,codiceUtente);
    }

    ArrayList<Integer> lista=preferitiDAO.doRetrieveByUtente(codiceUtente);
    ArrayList<Cellulare> preferiti=new ArrayList<>();

    for(Integer i:lista){
      Cellulare c=dao.doRetrieveById(i);
      preferiti.add(c);
    }
    request.setAttribute("preferiti",preferiti);

    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/preferiti.jsp");
    dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

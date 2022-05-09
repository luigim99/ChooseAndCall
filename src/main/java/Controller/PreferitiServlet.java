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

@WebServlet(name = "PreferitiServlet", value = "/preferiti_servlet")
public class PreferitiServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Utente utente=(Utente) request.getSession().getAttribute("utente");
    if(utente==null)
      throw new Controller.ServletException("Utente non loggato. Per accedere alla WishList fai il login o registrati.");

    String cellulare=request.getParameter("id");
    ArrayList<Cellulare> preferiti=new ArrayList<>();
    int idUtente=utente.getId();
    PreferitiDAO preferitiDAO=new PreferitiDAO();
    CellulareDAO dao=new CellulareDAO();

    if(cellulare!=null){
      int idCellulare=Integer.parseInt(cellulare);
      if(preferitiDAO.existCellulare(idUtente,idCellulare)==0){
          if(preferitiDAO.listaExist(idUtente)==0){
            preferitiDAO.doSaveLista(idUtente);
          }
          preferitiDAO.doSaveCellulare(idCellulare,idUtente);
      }
    }

    ArrayList<Integer> lista=preferitiDAO.doRetrieveByUtente(idUtente);
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

package Controller;

import Model.Cellulare;
import Model.CellulareDAO;
import Model.Utente;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AmministratoreCellulareServlet", value = "/amministratore_cellulare_servlet")
public class AmministratoreCellulareServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String op="";
    Utente u=(Utente) request.getSession().getAttribute("utente");
    if(u==null||!u.getAdmin()){
      throw new Controller.ServletException("Utente non autorizzato");
    }
    CellulareDAO dao=new CellulareDAO();
    String id=request.getParameter("id");
    if(id!=null){
      if(request.getParameter("rimuovi")!=null){
        dao.doDelete(Integer.parseInt(id));
        op="Rimozione";
        request.setAttribute("notifica","Prodotto rimosso con successo");
      }else{
        Cellulare c=dao.doRetrieveById(Integer.parseInt(id));
        op="Modifica";
        request.setAttribute("cellulare",c);
      }
    }else{
      op="Inserimento";
    }
    request.setAttribute("operazione",op);
    RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/jsp/amministratoreCellulare.jsp");
    requestDispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

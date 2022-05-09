package Controller;

import Model.Carrello;
import Model.CarrelloDAO;
import Model.CellulareDAO;
import Model.Utente;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CarrelloServlet", value = "/carrello_servlet")
public class CarrelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String idString=request.getParameter("id");
    String quant=request.getParameter("quant");
    CellulareDAO cellulareDAO=new CellulareDAO();
    CarrelloDAO carrelloDAO=new CarrelloDAO();
    Utente u=(Utente) request.getSession().getAttribute("utente");
    if(idString!=null){
      int id=Integer.parseInt(idString);
      if(u==null){
        Carrello carrello=(Carrello) request.getSession().getAttribute("carrello");
        if(carrello==null) {
          carrello = new Carrello();
          request.getSession().setAttribute("carrello", carrello);
        }
        if(quant!=null){
          int add=Integer.parseInt(quant);
          Carrello.CellulareQuantita cellQuant=carrello.get(id);
          if(cellQuant!=null){
            cellQuant.setQuantita(cellQuant.getQuantita()+add);
          }else{
            carrello.put(cellulareDAO.doRetrieveById(id),add);
          }
        }
        else{
            Carrello.CellulareQuantita cellQuant=carrello.get(id);
            if(cellQuant.getQuantita()>1){
              cellQuant.setQuantita(cellQuant.getQuantita()-1);
            }else{
              carrello.remove(id);
            }
        }
        request.getSession().setAttribute("carrello",carrello);
      }else{
        Carrello carrello;
        if(quant!=null) {
          int add=Integer.parseInt(quant);
          if (carrelloDAO.carrelloExist(u.getId()) == 0) {
            carrelloDAO.doSaveCarrello(u.getId());
          } else {
            if (carrelloDAO.existCellulare(u.getId(), id) == 0) {
              carrelloDAO.doSaveCellulare(id, u.getId(), add);
            }else{
              carrelloDAO.doUpdate(u.getId(),id,carrelloDAO.existCellulare(u.getId(),id)+add);
            }
          }
        }else{
          if(carrelloDAO.existCellulare(u.getId(),id)>1){
            carrelloDAO.doUpdate(u.getId(), id,carrelloDAO.existCellulare(u.getId(),id)-1);
          }else{
            carrelloDAO.doDelete(u.getId(),id);
          }
        }
        carrello=carrelloDAO.doRetrieveByUtente(u.getId());
        request.setAttribute("carrello",carrello);
      }
    }else{
      if(u!=null){
        Carrello carrello=carrelloDAO.doRetrieveByUtente(u.getId());
        request.getSession().setAttribute("carrello",carrello);
      }
    }
    RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/jsp/carrello.jsp");
    requestDispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

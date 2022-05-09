package Controller;

import Model.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProfiloServlet", value = "/profilo_servlet")
public class ProfiloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Utente u=(Utente) request.getSession().getAttribute("utente");
      if(u==null){
        throw new Controller.ServletException("Utente non loggato");
      }

      OrdineDAO oDao=new OrdineDAO();
      ArrayList<Ordine> ordini=oDao.doRetrieveByUtenteAll(u.getId());
      if(ordini!=null){
          for(Ordine o:ordini){
            ArrayList<Integer> idCellulari=oDao.doRetrieveByOrdineAll(o.getId(), u.getId());
            ArrayList<Cellulare> cellulari=new ArrayList<>();
            CellulareDAO dao=new CellulareDAO();
            for(Integer i:idCellulari){
              Cellulare c=dao.doRetrieveById(i);
              cellulari.add(c);
            }
            o.setCellulari(cellulari);
          }
      }
      request.setAttribute("ordini",ordini);
      request.getSession().setAttribute("utente",u);

      RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/profiloUtente.jsp");
      dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

package Controller;

import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DettagliServlet", value = "/dettagli_servlet")
public class DettagliServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, javax.servlet.ServletException {
    Utente u=(Utente) request.getSession().getAttribute("utente");
    if(u == null){
      throw new Controller.ServletException("Utente non loggato.");
    }
    if(!u.getAdmin()){
      throw new Controller.ServletException("Pagina accessibile solo agli admin.");
    }

    OrdineDAO ordineDAO=new OrdineDAO();
    CellulareDAO cellulareDAO=new CellulareDAO();

    int id=Integer.parseInt(request.getParameter("id"));
    ArrayList<Ordine> ordini=ordineDAO.doRetrieveByUtenteAll(id);

    if(ordini!=null){
      for(Ordine o:ordini){
        ArrayList<Integer> idCellulari=ordineDAO.doRetrieveByOrdineAll(o.getId(),id);
        ArrayList<Cellulare> cellulari=new ArrayList<>();

        for(Integer i:idCellulari){
          Cellulare c=cellulareDAO.doRetrieveById(i);
          cellulari.add(c);
        }
        o.setCellulari(cellulari);
      }
    }

    request.setAttribute("ordini",ordini);
    request.getSession().setAttribute("utente",u);

    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/amministratoreDettagli.jsp");
    dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
      doGet(request,response);
  }
}

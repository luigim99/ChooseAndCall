package Controller;

import Model.Cellulare;
import Model.CellulareDAO;
import Model.OrdineDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns="", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {

  @Override
  public void  init() throws ServletException{

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    OrdineDAO ordineDao=new OrdineDAO();
    CellulareDAO dao=new CellulareDAO();
    ArrayList<Integer> cellulariId=ordineDao.doRetrieveByVenduti();
    ArrayList<Cellulare> cellulari=new ArrayList<>();

    for(int i=0;i<6;i++){
      Cellulare c=dao.doRetrieveById(cellulariId.get(i));
      cellulari.add(c);
    }

    request.setAttribute("venduti",cellulari);
    request.setAttribute("cellulare1",cellulari.get(0));
    request.setAttribute("cellulare2",cellulari.get(1));

    RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    requestDispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}

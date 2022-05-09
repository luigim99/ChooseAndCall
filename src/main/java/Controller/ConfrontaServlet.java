package Controller;

import Model.Cellulare;
import Model.CellulareDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfrontaServlet", value = "/confronta_servlet")
public class ConfrontaServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String cellulare1= request.getParameter("cellulare1");
    String cellulare2= request.getParameter("cellulare2");
    if(cellulare1!=null && cellulare2!=null){
      CellulareDAO dao=new CellulareDAO();
      Cellulare c1=dao.doRetrieveByNome(cellulare1);
      Cellulare c2=dao.doRetrieveByNome(cellulare2);
      if(c1==null || c2==null){
        throw new Controller.ServletException("Nome di almeno uno dei cellulari selezionati errato.");
      }
      request.setAttribute("cellulare1",c1);
      request.setAttribute("cellulare2",c2);
    }
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/confronta.jsp");
    requestDispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

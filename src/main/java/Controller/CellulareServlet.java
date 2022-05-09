package Controller;

import Model.Cellulare;
import Model.CellulareDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CellulareServlet", value = "/cellulare_servlet")
public class CellulareServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
      int id;

      try{
        id=Integer.parseInt(request.getParameter("id"));
      }catch (Exception e){
        throw new Controller.ServletException("ID cellulare non valido");
      }

      CellulareDAO dao=new CellulareDAO();
      Cellulare cel= dao.doRetrieveById(id);
      if(cel==null){
        throw new Controller.ServletException("Cellulare non trovato");
      }

      request.setAttribute("cellulare",cel);

      RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/cellulare.jsp");
      dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
      doGet(request,response);
  }
}

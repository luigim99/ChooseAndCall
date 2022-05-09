package Controller;

import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RimuoviUtenteServlet", value = "/rimuovi_utente_servlet")
public class RimuoviUtenteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id=Integer.parseInt(request.getParameter("id"));
      UtenteDAO dao=new UtenteDAO();
      dao.doDelete(id);

      String dest=request.getHeader("referer");
      if(dest == null || dest.contains("/rimuovi_utente_servlet") || dest.trim().isEmpty()){
        dest = ".";
      }
    response.sendRedirect(dest);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

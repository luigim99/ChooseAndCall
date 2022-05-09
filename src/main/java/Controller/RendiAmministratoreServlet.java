package Controller;

import Model.Utente;
import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RendiAmministratoreServlet", value = "/rendi_amministratore_servlet")
public class RendiAmministratoreServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    UtenteDAO dao = new UtenteDAO();
    Utente u = dao.doRetrieveById(id);

    if(u != null){
      if(u.getAdmin()){
        dao.updateAdmin(id, false);
      }else {
        dao.updateAdmin(id, true);
      }
    }

    String dest = request.getHeader("referer");
    if(dest == null || dest.contains("/rendi_amministratore_servlet") || dest.trim().isEmpty()){
      dest = ".";
    }
    response.sendRedirect(dest);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

package Controller;

import Model.Utente;
import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login_servlet")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username=request.getParameter("username");
      String password=request.getParameter("password");
      Utente utente=null;
      UtenteDAO dao=new UtenteDAO();

      if(username!=null && password!=null){
        utente=dao.doRetrieveByUsernamePassword(username,password);
      }

      if(utente==null){
        throw new Controller.ServletException("Username o Password non validi");
      }
      request.getSession().setAttribute("utente",utente);
      String dest=request.getHeader("referer");
      if(dest==null||dest.contains("/login_servlet")||dest.trim().isEmpty()){
        dest=".";
      }
      response.sendRedirect(dest);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

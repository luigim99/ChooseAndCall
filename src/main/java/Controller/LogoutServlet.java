package Controller;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout_servlet")
public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(request.getSession().getAttribute("utente")!= null)
      request.getSession().removeAttribute("utente");

    if(request.getSession().getAttribute("carrello") != null){
      request.getSession().removeAttribute("carrello");
    }

    String dest = request.getHeader("referer");
    if( dest == null || dest.contains("/logout_servlet") || dest.trim().isEmpty()){
      dest = ".";
    }
    response.sendRedirect(dest);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

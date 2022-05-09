package Controller;

import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VerificaUsernameServlet", value = "/verifica_username_servlet")
public class VerificaUsernameServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UtenteDAO dao=new UtenteDAO();
    String user = request.getParameter("username");

    response.setContentType("text/xml");
    if(user != null && user.length() >= 6 && user.matches("^[0-9a-zA-Z]+$") && dao.doRetrieveByUsername(user) == null)
    {
      response.getWriter().append("<ok/>");
    }
    else {
      response.getWriter().append("<no/>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

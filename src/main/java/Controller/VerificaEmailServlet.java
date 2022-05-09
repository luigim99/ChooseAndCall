package Controller;

import Model.UtenteDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VerificaEmailServlet", value = "/verifica_email_servlet")
public class VerificaEmailServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UtenteDAO dao=new UtenteDAO();
    String email = request.getParameter("email");

    response.setContentType("text/xml");
    if((email != null) && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$") && dao.doRetrieveByEmail(email) == null)
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

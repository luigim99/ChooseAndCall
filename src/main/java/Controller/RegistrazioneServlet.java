package Controller;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrazioneServlet", value = "/registrazione_servlet")
public class RegistrazioneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(request.getSession().getAttribute("utente") != null){
      throw new Controller.ServletException("Utente Loggato");
    }

    RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/registrazione.jsp");
    disp.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }
}

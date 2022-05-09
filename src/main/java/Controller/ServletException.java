package Controller;


import javax.servlet.annotation.*;

@WebServlet(name = "ServletException")
public class ServletException extends javax.servlet.ServletException {
  private static final long serialVersionUID = 1L;

  public ServletException(String message) {
    super(message);
  }

  public ServletException(String message, Throwable rootCause) {
    super(message, rootCause);
  }

  public ServletException(Throwable rootCause) {
    super(rootCause);
  }
}

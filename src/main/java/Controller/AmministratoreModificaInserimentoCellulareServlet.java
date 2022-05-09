package Controller;

import Model.Cellulare;
import Model.CellulareDAO;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@MultipartConfig
@WebServlet(name = "AmministratoreModificaInserimentoCellulareServlet", value = "/amministratore_modifica_inserimento_cellulare_servlet")
public class AmministratoreModificaInserimentoCellulareServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cellulare c=new Cellulare();
    String operazione="";
    CellulareDAO dao=new CellulareDAO();

    String id=request.getParameter("id");
    String nome=request.getParameter("nome");
    String marca=request.getParameter("marca");
    String schermo=request.getParameter("schermo");
    String ram=request.getParameter("ram");
    String memoria=request.getParameter("memoria");
    String fotocamera=request.getParameter("fotocamera");
    String batteria=request.getParameter("batteria");
    String prezzo=request.getParameter("prezzo");

    if(dao.doRetrieveByNome(nome)!=null){
      throw new Controller.ServletException("Cellulare gia presente");
    }

    Part filePart = request.getPart("foto");
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
    if(!nome.equalsIgnoreCase(fileName)){
      throw new Controller.ServletException("Nome file foto differente nome del cellulare");
    }

    c.setNome(nome);
    c.setMarca(marca);
    c.setSchermo(Float.parseFloat(schermo));
    c.setRam(Integer.parseInt(ram));
    c.setMemoria(Integer.parseInt(memoria));
    c.setFotocamera(Integer.parseInt(fotocamera));
    c.setBatteria(Integer.parseInt(batteria));
    c.setPrezzo(Float.parseFloat(prezzo));


    String op=request.getParameter("operazione");
    if(op.equalsIgnoreCase("inserimento")){
      operazione="Inserimento";
      aggiuntaFoto(request);
      dao.doSave(c);
      request.setAttribute("notifica", "Prodotto inserito con successo.");
    }else {
      operazione="Modifica";
      c.setId(Integer.parseInt(id));
      dao.doUpdate(c);
      request.setAttribute("notifica", "Prodotto modificato con successo.");
    }
    request.setAttribute("operazione",operazione);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/amministratoreCellulare.jsp");
    requestDispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }


  private void aggiuntaFoto(HttpServletRequest request) throws IOException, ServletException {
    String CARTELLA_UPLOAD = "images";  //cartella in cui verranno salvate le immagini prese dal form

    Part filePart = request.getPart("foto");
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

    String destinazione = CARTELLA_UPLOAD + File.separator + fileName;
    Path pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));

    InputStream fileInputStream = filePart.getInputStream();
    // scrive il file
    Files.copy(fileInputStream, pathDestinazione);
  }
}

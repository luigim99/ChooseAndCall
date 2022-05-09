package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrelloDAO {

  public void doSaveCarrello(int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT INTO carrello VALUES (?)");
      ps.setInt(1, utente);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doSaveCellulare(int cellulare, int utente,int quant) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT INTO cellulareCarrello VALUES (?,?,?)");
      ps.setInt(1, utente);
      ps.setInt(2, cellulare);
      ps.setInt(3,quant);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doDeleteCarrello(int cellulare, int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM cellulareCarrello WHERE cellulare= ? AND utente = ?");
      ps.setInt(1, cellulare);
      ps.setInt(2, utente);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doDeleteAll(int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM carrello WHERE utente = ?");
      ps.setInt(1, utente);

      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public int carrelloExist(int utente){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT utente FROM carrello WHERE utente=?");
      ps.setInt(1, utente);

      int codiceUtente = 0;
      ResultSet rs = ps.executeQuery();
      if(rs.next()) {
        codiceUtente = (rs.getInt(1));
      }
      return codiceUtente;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int existCellulare(int utente, int cellulare){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT quantita FROM cellulareCarrello WHERE utente=? AND cellulare=?");
      ps.setInt(1, utente);
      ps.setInt(2,cellulare);

      int quantita = 0;
      ResultSet rs = ps.executeQuery();
      if(rs.next()) {
        quantita = (rs.getInt(1));
      }
      return quantita;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doUpdate(int utente,int cellulare,int q) {
    try(Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("UPDATE cellulareCarrello SET quantita=?  WHERE utente=? AND cellulare=?");
      ps.setInt(1,q);
      ps.setInt(2,utente);
      ps.setInt(3,cellulare);

      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doDelete(int utente, int cellulare){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM cellulareCarrello WHERE utente = ? AND cellulare = ?");
      ps.setInt(1, utente);
      ps.setInt(2, cellulare);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Carrello doRetrieveByUtente(int ut) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT cellulare,quantita FROM cellulareCarrello WHERE utente=?");
      ps.setInt(1,ut);
      ResultSet rs = ps.executeQuery();

      Carrello cart=new Carrello();
      Cellulare c;
      CellulareDAO dao=new CellulareDAO();
      int q;

      while (rs.next()) {
        c=dao.doRetrieveById(rs.getInt(1));
        q=rs.getInt(2);

        cart.put(c,q);
      }
      return cart;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreferitiDAO {

  public void doSaveLista(int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT INTO listaPreferiti VALUES (?)");
      ps.setInt(1, utente);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doSaveCellulare(int cellulare, int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT INTO listaCellulare VALUES (?,?)");
      ps.setInt(1, utente);
      ps.setInt(2, cellulare);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doDeleteLista(int cellulare, int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM listaCellulare WHERE cellulare= ? AND lista = ?");
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
      PreparedStatement ps = con.prepareStatement("DELETE FROM listaCellulare WHERE lista = ?");
      ps.setInt(1, utente);

      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public ArrayList<Integer> doRetrieveByUtente(int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT cellulare FROM listaCellulare WHERE lista=?");
      ps.setInt(1, utente);

      int codiceCellulare = 0;
      ArrayList<Integer> codici = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        codiceCellulare = (rs.getInt(1));
        codici.add(codiceCellulare);
      }
      return codici;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int listaExist(int utente){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT utente FROM listaPreferiti WHERE utente=?");
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
      PreparedStatement ps = con.prepareStatement("SELECT cellulare FROM listaCellulare WHERE lista=? AND cellulare=?");
      ps.setInt(1, utente);
      ps.setInt(2,cellulare);

      int codice = 0;
      ResultSet rs = ps.executeQuery();
      if(rs.next()) {
        codice = (rs.getInt(1));
      }
      return codice;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAO {

  public void doSave(int utente, String data,float prezzo, ArrayList<Integer> cellulari) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT INTO ordine (utente,prezzo,data) VALUES (?,?,?)");
      ps.setInt(1, utente);
      ps.setFloat(2,prezzo);
      ps.setString(3,data);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

      int last = this.returnMaxOrdine();

      for (Integer c:cellulari){
        ps = con.prepareStatement("INSERT INTO ordineCellulare (ordine,cellulare) VALUES (?, ?)");
        ps.setInt(1, last);
        ps.setInt(2,c);

        if (ps.executeUpdate() != 1) {
          throw new RuntimeException("INSERT error.");
        }
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int returnMaxOrdine(){
    try (Connection con = ConPool.getConnection()) {
      int value = 0;
      PreparedStatement ps = con.prepareStatement("SELECT MAX(id) FROM ordine");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        value = rs.getInt(1);
      }
      return value;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public  ArrayList<Ordine> doRetrieveByUtenteAll(int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT id, utente,prezzo,data FROM ordine WHERE utente = ?");
      ps.setInt(1, utente);

      ArrayList<Ordine> ordini = new ArrayList<>();

      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        Ordine o = new Ordine();
        o.setId(rs.getInt(1));
        o.setUtente(rs.getInt(2));
        o.setPrezzo(rs.getFloat(3));
        o.setData(rs.getString(4));

        ordini.add(o);
      }
      return ordini;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public  ArrayList<Integer> doRetrieveByOrdineAll(int ordine, int utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT ordineCellulare.cellulare FROM ordine, ordineCellulare WHERE ordine.utente = ? AND ordine.id = ? AND ordine.id = ordineCellulare.ordine");
      ps.setInt(1, utente);
      ps.setInt(2, ordine);

      ArrayList<Integer> cellulari = new ArrayList<>();

      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        int cod = rs.getInt(1);
        cellulari.add(cod);
      }
      return cellulari;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public  ArrayList<Integer> doRetrieveByVenduti() {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT ordineCellulare.cellulare, COUNT(*) FROM ordineCellulare GROUP BY cellulare ");

      ArrayList<Integer> cellulari = new ArrayList<>();

      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        int cod = rs.getInt(1);
        cellulari.add(cod);
      }
      return cellulari;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}


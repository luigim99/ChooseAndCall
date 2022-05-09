package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

  public List<Utente> doRetrieveAll(){
    List<Utente> utenti=new ArrayList<>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM utente");
      ResultSet rs= ps.executeQuery();
      while(rs.next()){
        Utente u=new Utente();
        u.setId(rs.getInt(1));
        u.setUsername(rs.getString(2));
        u.setEmail(rs.getString(3));
        u.setPassword(rs.getString(4));
        u.setNome(rs.getString(5));
        u.setCognome(rs.getString(6));
        u.setDataDiNascita(rs.getString(7));
        u.setSesso(rs.getString(8));
        u.setVia(rs.getString(9));
        u.setnCivico(rs.getInt(10));
        u.setCitta(rs.getString(11));
        u.setProvincia(rs.getString(12));
        u.setCAP(rs.getString(13));
        u.setAdmin(rs.getBoolean(14));
        utenti.add(u);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return utenti;
  }

  public Utente doRetrieveByUsername(String username){
    try(Connection con = ConPool.getConnection()){
      PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE username =?");
      ps.setString(1,username);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        Utente u = new Utente();
        u.setId(rs.getInt(1));
        u.setUsername(rs.getString(2));
        u.setEmail(rs.getString(3));
        u.setPassword(rs.getString(4));
        u.setNome(rs.getString(5));
        u.setCognome(rs.getString(6));
        u.setDataDiNascita(rs.getString(7));
        u.setSesso(rs.getString(8));
        u.setVia(rs.getString(9));
        u.setnCivico(rs.getInt(10));
        u.setCitta(rs.getString(11));
        u.setProvincia(rs.getString(12));
        u.setCAP(rs.getString(13));
        u.setAdmin(rs.getBoolean(14));
        return u;
      }
      return null;
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

  public void doSave(Utente u){
    try(Connection c = ConPool.getConnection()){
      PreparedStatement ps = c.prepareStatement("INSERT INTO UTENTE(username, email, password, nome, cognome,dataDiNascita,sesso,via,nCivico,citta,provincia,CAP,admin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, u.getUsername());
      ps.setString(2, u.getEmail());
      ps.setString(3, u.getPassword());
      ps.setString(4, u.getNome());
      ps.setString(5, u.getCognome());
      ps.setString(6, u.getDataDiNascita());
      ps.setString(7, u.getSesso());
      ps.setString(8, u.getVia());
      ps.setInt(9, u.getnCivico());
      ps.setString(10, u.getCitta());
      ps.setString(11, u.getProvincia());
      ps.setString(12, u.getCAP());
      ps.setBoolean(13, u.getAdmin());
      if(ps.executeUpdate() != 1){
        throw new RuntimeException("INSERT error");
      }
    } catch (SQLException e){
      throw new RuntimeException();
    }
  }

  public Utente doRetrieveByUsernamePassword(String username, String password){
    try(Connection con= ConPool.getConnection()){
      PreparedStatement ps = con.prepareStatement(
          "SELECT * FROM utente WHERE username=? AND password = ?");
      ps.setString(1,username);
      ps.setString(2,password);
      ResultSet rs=ps.executeQuery();
      if(rs.next()){
        Utente u= new Utente();
        u.setId(rs.getInt(1));
        u.setUsername(rs.getString(2));
        u.setEmail(rs.getString(3));
        u.setPassword(rs.getString(4));
        u.setNome(rs.getString(5));
        u.setCognome(rs.getString(6));
        u.setDataDiNascita(rs.getString(7));
        u.setSesso(rs.getString(8));
        u.setVia(rs.getString(9));
        u.setnCivico(rs.getInt(10));
        u.setCitta(rs.getString(11));
        u.setProvincia(rs.getString(12));
        u.setCAP(rs.getString(13));
        u.setAdmin(rs.getBoolean(14));
        return u;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Utente doRetrieveById(int id){
    try(Connection con = ConPool.getConnection()){
      PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE id =?");
      ps.setInt(1,id);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        Utente u = new Utente();
        u.setId(rs.getInt(1));
        u.setUsername(rs.getString(2));
        u.setEmail(rs.getString(3));
        u.setPassword(rs.getString(4));
        u.setNome(rs.getString(5));
        u.setCognome(rs.getString(6));
        u.setDataDiNascita(rs.getString(7));
        u.setSesso(rs.getString(8));
        u.setVia(rs.getString(9));
        u.setnCivico(rs.getInt(10));
        u.setCitta(rs.getString(11));
        u.setProvincia(rs.getString(12));
        u.setCAP(rs.getString(13));
        u.setAdmin(rs.getBoolean(14));
        return u;
      }
      return null;
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

  public Utente doRetrieveByEmail(String email){
    try(Connection con = ConPool.getConnection()){
      PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE email =?");
      ps.setString(1,email);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        Utente u = new Utente();
        u.setId(rs.getInt(1));
        u.setUsername(rs.getString(2));
        u.setEmail(rs.getString(3));
        u.setPassword(rs.getString(4));
        u.setNome(rs.getString(5));
        u.setCognome(rs.getString(6));
        u.setDataDiNascita(rs.getString(7));
        u.setSesso(rs.getString(8));
        u.setVia(rs.getString(9));
        u.setnCivico(rs.getInt(10));
        u.setCitta(rs.getString(11));
        u.setProvincia(rs.getString(12));
        u.setCAP(rs.getString(13));
        u.setAdmin(rs.getBoolean(14));
        return u;
      }
      return null;
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

  public void doDelete(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE id = ?");
      ps.setInt(1, id);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void updateAdmin(int id, boolean admin) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("UPDATE utente SET admin = ? WHERE id = ?");
      ps.setBoolean(1,admin);
      ps.setInt(2, id);

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("UPDATE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

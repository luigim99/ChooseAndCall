package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CellulareDAO {

  public List<Cellulare> doRetrieveAll(){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare");
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public Cellulare doRetrieveById(int id){
    Cellulare c=new Cellulare();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE id=?");
      ps.setInt(1,id);
      ResultSet rs=ps.executeQuery();
      if(rs.next()) {
        c.setId(rs.getInt(1));
        c.setNome(rs.getString(2));
        c.setMarca(rs.getString(3));
        c.setSchermo(rs.getFloat(4));
        c.setRam(rs.getInt(5));
        c.setMemoria(rs.getInt(6));
        c.setFotocamera(rs.getInt(7));
        c.setBatteria(rs.getInt(8));
        c.setPrezzo(rs.getFloat(9));
      }
      } catch (SQLException e) {
      e.printStackTrace();
    }
    return c;
  }

  public Cellulare doRetrieveByNome(String nome){
    Cellulare c=null;
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE nome=?");
      ps.setString(1,nome);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return c;
  }

  public List<Cellulare> doRetrieveByMarca(String marca){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE marca=?");
      ps.setString(1,marca);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveBySchermo(float schermo){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE schermo>=? ORDER BY schermo");
      ps.setFloat(1,schermo);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByRam(int ram){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE ram>=? ORDER BY ram");
      ps.setInt(1,ram);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByMemoria(int memoria){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE memoria>=? ORDER BY memoria");
      ps.setInt(1,memoria);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByFotocamera(int fotocamera){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE fotocamera>=? ORDER BY fotocamera");
      ps.setInt(1,fotocamera);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByBatteria(int batteria){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE batteria>=? ORDER BY batteria");
      ps.setInt(1,batteria);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByPrezzoCrescente(){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare ORDER BY prezzo");
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByPrezzoCrescente(float prezzo){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE prezzo>=? ORDER BY prezzo");
      ps.setFloat(1,prezzo);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByPrezzoDecrescente(){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare ORDER BY prezzo DESC");
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public List<Cellulare> doRetrieveByPrezzoDecrescente(float prezzo){
    List<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps=con.prepareStatement("SELECT * FROM cellulare WHERE prezzo>=? ORDER BY prezzo DESC");
      ps.setFloat(1,prezzo);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }

  public void doSave(Cellulare c) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("INSERT INTO cellulare (nome, marca, schermo, ram, memoria, fotocamera, batteria, prezzo) VALUES(?,?,?,?,?,?,?,?)");

      ps.setString(1, c.getNome());
      ps.setString(2, c.getMarca());
      ps.setFloat(3, c.getSchermo());
      ps.setInt(4, c.getRam());
      ps.setInt(5, c.getMemoria());
      ps.setInt(6, c.getFotocamera());
      ps.setInt(7, c.getBatteria());
      ps.setFloat(8, c.getPrezzo());

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doUpdate(Cellulare c) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("UPDATE cellulare SET nome=?, marca=?, schermo=?, ram=?, memoria=?, fotocamera=?, batteria=?, prezzo=? WHERE id=?");

      ps.setString(1, c.getNome());
      ps.setString(2, c.getMarca());
      ps.setFloat(3, c.getSchermo());
      ps.setInt(4, c.getRam());
      ps.setInt(5, c.getMemoria());
      ps.setInt(6, c.getFotocamera());
      ps.setInt(7, c.getBatteria());
      ps.setFloat(8, c.getPrezzo());
      ps.setInt(9,c.getId());

      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void doDelete(int id) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM cellulare WHERE id=?");
      ps.setInt(1, id);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public ArrayList<Cellulare> doRetrieveByNomeOrMarca(String parola){
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement ps = con.prepareStatement("SELECT * FROM cellulare WHERE nome LIKE CONCAT('%',?,'%') or marca LIKE CONCAT('%',?,'%')");

      ps.setString(1, parola);
      ps.setString(2, parola);
      ArrayList<Cellulare> cellulari = new ArrayList<>();
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
      return cellulari;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }



  public ArrayList<Cellulare> doRetrieveByFiltri(float schermo,int ram,int memoria,int fotocamera,int batteria,float prezzo,boolean asc){
    ArrayList<Cellulare> cellulari=new ArrayList<Cellulare>();
    try(Connection con=ConPool.getConnection()){
      PreparedStatement ps;
      if (asc==true)
        ps=con.prepareStatement("SELECT * FROM cellulare WHERE prezzo<= ? AND schermo >= ? AND ram >= ? AND memoria >= ? AND fotocamera >=? AND batteria >= ? ORDER BY prezzo ASC ");
      else
        ps=con.prepareStatement("SELECT * FROM cellulare WHERE prezzo<= ? AND schermo >= ? AND ram >= ? AND memoria >= ? AND fotocamera >=? AND batteria >= ? ORDER BY prezzo DESC ");
      ps.setFloat(1,prezzo);
      ps.setFloat(2,schermo);
      ps.setInt(3,ram);
      ps.setInt(4,memoria);
      ps.setInt(5,fotocamera);
      ps.setInt(6,batteria);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        Cellulare c=new Cellulare(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getFloat(9));
        cellulari.add(c);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return cellulari;
  }
}



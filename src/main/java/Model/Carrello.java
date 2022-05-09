package Model;

import java.util.*;

public class Carrello {

  public static class CellulareQuantita {
    private Cellulare Cellulare;
    private int quantita;

    public CellulareQuantita(Cellulare Cellulare, int quantita) {
      this.Cellulare = Cellulare;
      this.quantita = quantita;
    }

    public CellulareQuantita() {

    }

    public Cellulare getCellulare() {
      return Cellulare;
    }

    public void setCellulare(Cellulare Cellulare) {
      this.Cellulare = Cellulare;
    }

    public int getQuantita() {
      return quantita;
    }

    public void setQuantita(int quantita) {
      this.quantita = quantita;
    }

    public float getPrezzoTot(){return quantita * Cellulare.getPrezzo();
    }
  }

  private LinkedHashMap<Integer, CellulareQuantita> cellulari = new LinkedHashMap<>();

  public Collection<CellulareQuantita> getcellulari() {
    return cellulari.values();
  }

  public List<CellulareQuantita> getcellulariArray(){
    ArrayList<CellulareQuantita> pq = new ArrayList<CellulareQuantita>();
    Iterator it = cellulari.entrySet().iterator();
    while (it.hasNext()){
      Map.Entry entry= (Map.Entry) it.next();
      CellulareQuantita p =(CellulareQuantita) entry.getValue();
      System.out.println(p.getCellulare().getNome());
      pq.add(p);
    }
    return pq;
  }

  public CellulareQuantita get(int  prodId) {
    return cellulari.get(prodId);
  }

  public void put(Cellulare Cellulare, int quantità) {
    cellulari.put(Integer.valueOf(Cellulare.getId()), new CellulareQuantita(Cellulare, quantità));
  }
  public CellulareQuantita remove(int prodId){
    return cellulari.remove(prodId);
  }

  public float getPrezzoTot(){
    return (float) cellulari.values().stream().mapToDouble(p-> p.getPrezzoTot()).sum();
  }

  public boolean isEmpty() {
    return cellulari.isEmpty();
  }
}

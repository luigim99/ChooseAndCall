package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Ordine {
  int id,utente;
  ArrayList<Cellulare> cellulari;
  Float prezzo;
  String data;

  public Ordine(int id, int utente, ArrayList<Cellulare> cellulari, Float prezzo, String data) {
    this.id = id;
    this.utente = utente;
    this.cellulari = cellulari;
    this.prezzo = prezzo;
    this.data = data;
  }

  public Ordine() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUtente() {
    return utente;
  }

  public void setUtente(int utente) {
    this.utente = utente;
  }

  public ArrayList<Cellulare> getCellulari() {
    return cellulari;
  }

  public void setCellulari(ArrayList<Cellulare> cellulari) {
    this.cellulari = cellulari;
  }

  public Float getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(Float prezzo) {
    this.prezzo = prezzo;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Ordine{" +
        "id=" + id +
        ", utente=" + utente +
        ", cellulari=" + cellulari +
        ", prezzo=" + prezzo +
        ", data='" + data + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ordine ordine = (Ordine) o;
    return id == ordine.id && utente == ordine.utente && Objects.equals(cellulari, ordine.cellulari) && Objects.equals(prezzo, ordine.prezzo) && Objects.equals(data, ordine.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, utente, cellulari, prezzo, data);
  }
}

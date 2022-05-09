package Model;

import java.util.Objects;

public class Cellulare {
  private int id;
  private String nome;
  private String marca;
  private float schermo;
  private int ram;
  private int memoria;
  private int fotocamera;
  private int batteria;
  private float prezzo;

  public Cellulare() {
  }

  public Cellulare(int id, String nome, String marca, float schermo, int ram, int memoria, int fotocamera, int batteria, float prezzo) {
    this.id = id;
    this.nome = nome;
    this.marca = marca;
    this.schermo = schermo;
    this.ram = ram;
    this.memoria = memoria;
    this.fotocamera = fotocamera;
    this.batteria = batteria;
    this.prezzo = prezzo;
  }

  public Cellulare(String nome, String marca, float schermo, int ram, int memoria, int fotocamera, int batteria, float prezzo) {
    this.nome = nome;
    this.marca = marca;
    this.schermo = schermo;
    this.ram = ram;
    this.memoria = memoria;
    this.fotocamera = fotocamera;
    this.batteria = batteria;
    this.prezzo = prezzo;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getMarca() {
    return marca;
  }

  public float getSchermo() {
    return schermo;
  }

  public int getRam() {
    return ram;
  }

  public int getMemoria() {
    return memoria;
  }

  public int getFotocamera() {
    return fotocamera;
  }

  public int getBatteria() {
    return batteria;
  }

  public float getPrezzo() {
    return prezzo;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setSchermo(float schermo) {
    this.schermo = schermo;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public void setMemoria(int memoria) {
    this.memoria = memoria;
  }

  public void setFotocamera(int fotocamera) {
    this.fotocamera = fotocamera;
  }

  public void setBatteria(int batteria) {
    this.batteria = batteria;
  }

  public void setPrezzo(float prezzo) {
    this.prezzo = prezzo;
  }

  @Override
  public String toString() {
    return "Cellulare{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", marca='" + marca + '\'' +
        ", schermo=" + schermo +
        ", ram=" + ram +
        ", memoria=" + memoria +
        ", fotocamera=" + fotocamera +
        ", batteria=" + batteria +
        ", prezzo=" + prezzo +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cellulare cellulare = (Cellulare) o;
    return id == cellulare.id && Float.compare(cellulare.schermo, schermo) == 0 && ram == cellulare.ram && memoria == cellulare.memoria && fotocamera == cellulare.fotocamera && batteria == cellulare.batteria && Float.compare(cellulare.prezzo, prezzo) == 0 && Objects.equals(nome, cellulare.nome) && Objects.equals(marca, cellulare.marca);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, marca, schermo, ram, memoria, fotocamera, batteria, prezzo);
  }
}

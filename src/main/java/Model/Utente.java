package Model;

import java.util.Objects;

public class Utente {
  private int id;
  private String username;
  private String email;
  private String password;
  private String nome;
  private String cognome;
  private String dataDiNascita;
  private String sesso;
  private String via;
  private int nCivico;
  private String citta;
  private String provincia;
  private String CAP;
  private boolean admin;

  public Utente() {

  }

  public Utente(int id,String username, String email, String password, String nome, String cognome,boolean admin) {
    this.id=id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.nome = nome;
    this.cognome = cognome;
    this.admin=admin;
  }

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public boolean getAdmin() { return admin; }

  public void setAdmin(boolean admin) { this.admin = admin; }

  public String getDataDiNascita() { return dataDiNascita; }

  public void setDataDiNascita(String dataDiNascita) { this.dataDiNascita = dataDiNascita; }

  public String getSesso() { return sesso; }

  public void setSesso(String sesso) { this.sesso = sesso; }

  public String getVia() { return via; }

  public void setVia(String via) { this.via = via; }

  public int getnCivico() { return nCivico; }

  public void setnCivico(int nCivico) { this.nCivico = nCivico; }

  public String getCitta() { return citta; }

  public void setCitta(String citta) { this.citta = citta; }

  public String getProvincia() { return provincia; }

  public void setProvincia(String provincia) { this.provincia = provincia; }

  public String getCAP() { return CAP; }

  public void setCAP(String CAP) { this.CAP = CAP; }

  @Override
  public String toString() {
    return "Utente{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", nome='" + nome + '\'' +
        ", cognome='" + cognome + '\'' +
        ", dataDiNascita='" + dataDiNascita + '\'' +
        ", sesso='" + sesso + '\'' +
        ", via='" + via + '\'' +
        ", nCivico=" + nCivico +
        ", citta='" + citta + '\'' +
        ", provincia='" + provincia + '\'' +
        ", CAP='" + CAP + '\'' +
        ", admin=" + admin +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Utente utente = (Utente) o;
    return id == utente.id && nCivico == utente.nCivico && admin == utente.admin && Objects.equals(username, utente.username) && Objects.equals(email, utente.email) && Objects.equals(password, utente.password) && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome) && Objects.equals(dataDiNascita, utente.dataDiNascita) && Objects.equals(sesso, utente.sesso) && Objects.equals(via, utente.via) && Objects.equals(citta, utente.citta) && Objects.equals(provincia, utente.provincia) && Objects.equals(CAP, utente.CAP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, password, nome, cognome, dataDiNascita, sesso, via, nCivico, citta, provincia, CAP, admin);
  }

}
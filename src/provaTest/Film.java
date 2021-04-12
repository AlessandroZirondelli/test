package provaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Film{
    String nome;
    String descrizione;
    int d;
    LocalDate date;
    LocalTime time;
    public Film(String nome, String descrizione, int d, LocalDate date, LocalTime time) {
        this.nome=nome;
        this.descrizione=descrizione;
        this.d=d;
        this.date=date;
        this.time=time;
       
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Film [nome=" + nome + ", descrizione=" + descrizione + ", d=" + d + ", date=" + date + ", time=" + time
                + "]";
    }
   

 
    
}

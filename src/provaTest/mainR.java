/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package provaTest;
 import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
       import java.util.stream.Collectors;


import com.google.gson.internal.LinkedTreeMap;
 import com.google.gson.reflect.TypeToken;

public class mainR {
   public static void main(String[] args) {
         /*      DateTime fi = new DateTime();
               //System.out.println(f);
               Instant i = new Instant();
             //  System.out.print(i);
               LocalTime l = new LocalTime();
               System.out.println(l);
               LocalDate d = new LocalDate();
               System.out.print(d);
              */
               Set<Film> setF = new HashSet<>();
               LocalTime localTime = LocalTime.now();
               LocalDate localDate = LocalDate.now();
               
               System.out.println(localDate+"+++++++");
               //Calendar c = Calendar().;
               Film film = new Film("Film1","B",1,localDate,localTime); 
               Film film1 = new Film("Film2","B",1,localDate,localTime); 
           
            //   Film1 f1 = new Film1(new Calenda)
             
               setF.add(film);
               setF.add(film1);
               
             
               System.out.println("SCRITTURA" + setF);
               
               RW<Film> re = new RW<Film>();
               re.write(setF);
               Type set = new TypeToken<Set<Film>>() {}.getType();
              Set<Film> cp = re.read(Film.class);
             
              System.out.println(cp.getClass());
              System.out.println("LETTURA" + cp);
              System.out.println(cp.stream().findAny().get());
             //  Optional<Film> f = cp.stream().findAny();
              Film f = cp.stream().findAny().get();
              System.out.print(f);
          
          

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import java.util.HashSet;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sobczak.lukasz.spttest.httpClient.HttpReport2;

/**
 *
 * @author piko
 */
@Component
public class TestRunner implements CommandLineRunner {

    //private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private SWReportRepository sWRepository;
    
    @Autowired
    SWReportSubRepository sWSubRepository;
    
    @Autowired
    SWService sw;

   // ReportSubresult[] srt=  {new ReportSubresult(1, null, "Sr1", "Sr2", "Sr3", "Sr4", "Sr5", "Sr6")};
    
    @Override
    //@Transactional
    public void run(String... args) throws Exception {

        //logger.info("initializing users");
       /*
        System.out.println("poczatek bazodanowania");
        
        var u1 = new Report("S1","S2","S12", new HashSet<ReportSubresult>()  );
        var s1 = new ReportSubresult(1, u1, "Sr1", "Sr2", "Sr3", "Sr4", "Sr5", "Sr6");
        u1.results.add(s1);
        sWRepository.save(u1);
        

        var u2 = new Report("S4","S5","S166", new HashSet<ReportSubresult>()   );
        sWRepository.save(u2);

        var u3 = new Report("S1233","S2444","S1332", new HashSet<ReportSubresult>()  );
        sWRepository.save(u3);
        System.out.println(" koniec bazodanowania");
    }*/
   /*  var rq = new RestQuery();
     rq.query_criteria_character_phrase = "Skywalker";
     rq.query_criteria_planet_name = "Tatooine";
     sw.createOrUpdate("kokoszka", rq); 
     
     rq.query_criteria_character_phrase = "Luke";
     rq.query_criteria_planet_name = "Tatooine";
     sw.createOrUpdate("kura", rq);*/
    }
}

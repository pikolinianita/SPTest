/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.SPTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sobczak.lukasz.httpClient.HttpReport2;

/**
 *
 * @author piko
 */

@Service
class SWService {
    
    @Autowired
    private SWReportRepository sWRepository;
    
    @Autowired
    private ReportFactory reportFactory;
    
    //@Autowired
   // private DBManager db;
    
    //ReportSubresult[] srt=  {new ReportSubresult(1, "Sr1", "Sr2", "Sr3", "Sr4", "Sr5", "Sr6")};

    Report getReport(String id) {
        
        return sWRepository.findById(id).get();
    }

    List<Report> getAllReports() {
        return new LinkedList ((Collection) sWRepository.findAll());
    }

    @Transactional
    void createOrUpdate(String id, RestQuery restQuery) {
        System.out.println("will make" + restQuery);
        HttpReport2 reportHttp = HttpReport2.create(restQuery.getQuery_criteria_character_phrase(), restQuery.getQuery_criteria_planet_name());
        String status = reportHttp.checkStatus();
        if (!status.equals("Ok")) {
          //TODO Throw Error?
        }
        Report rw = reportFactory.createReport(id, reportHttp);
       // db.save(rw);
       sWRepository.save(rw);
        System.out.println("Created :" + restQuery);
    }

    void deleteAll() {
        System.out.println("Deleted All");
        sWRepository.deleteAll();
    }

    void delete(String id) {
        System.out.println("Delerted: " + id);
        sWRepository.deleteById(id);
    }
    
}

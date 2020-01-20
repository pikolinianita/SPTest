/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sobczak.lukasz.spttest.httpClient.HttpReport2;

/**
 *
 * @author piko
 * Class takes requests from REST and makes requests to HTTP part and to Hibernate repository.
 * Throws Exceptions if GET or DELETE ask for wrong IDs
 */

@Service
class SWService {
    
    @Autowired
    private SWReportRepository sWRepository;
    
    @Autowired
    private ReportFactory reportFactory;
    
    
    Report getReport(String id) {
        
        return sWRepository.findById(id).orElseThrow(() -> { throw new MyExc.NoSuchRecord("There is no record with ID " + id);
        });
    }

    List<Report> getAllReports() {
        return new LinkedList ((Collection) sWRepository.findAll());
    }

    @Transactional
    void createOrUpdate(String id, RestQuery restQuery) {
        System.out.println("will make" + restQuery);
        HttpReport2 reportHttp = HttpReport2.create(restQuery.getQuery_criteria_character_phrase(), restQuery.getQuery_criteria_planet_name());
                     
        Report rw = reportFactory.createReport(id, reportHttp);
        
        if(sWRepository.findById(id).isPresent()) {
            delete(id);
        }
       
       sWRepository.save(rw);
        System.out.println("Created :" + restQuery);
    }

    void deleteAll() {
        System.out.println("Deleted All");
        sWRepository.deleteAll();
    }

    void delete(String id) {
        System.out.println("Delerted: " + id);
        try{
        sWRepository.deleteById(id);
        } catch (IllegalArgumentException e){
            throw new MyExc.NoSuchRecord("There is no record with ID " + id);
        }
    }
    
}

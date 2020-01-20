/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author piko
 * Rest controller - sends requests to SWService
 */
@RestController
public class LRestController {
        
    @Autowired
    SWService sWService;

    @GetMapping("/report/{id}")
    @ResponseBody Report findOne(@PathVariable String id) {
        return sWService.getReport(id);
    }

    @GetMapping("/report")
    @ResponseBody List<Report> findAll() {
        return sWService.getAllReports();
    }

    @PutMapping(value = "/report/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addOne (@PathVariable String id, @RequestBody RestQuery restQuery) {
        sWService.createOrUpdate(id, restQuery);
        }
    
    @DeleteMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    void deleteAll(){
       sWService.deleteAll();
    }
    
    @DeleteMapping("report/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteOne(@PathVariable String id){
        sWService.delete(id);
        
    }
    
    
  }
    


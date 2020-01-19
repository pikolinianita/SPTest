/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.SPTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author piko
 */
@RestController
public class LRestController {
        
    @Autowired
    SWService sWService;

    @GetMapping("/report/{id}")
    @ResponseBody Report findOne(@PathVariable String id) {
        System.out.println("Get One Repoort: " + id);
        return sWService.getReport(id);
    }

    @GetMapping("/report")
    @ResponseBody List<Report> findAll() {
        System.out.println("Get All Reports");
        return sWService.getAllReports();
    }

    @PutMapping(value = "/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addOne (@PathVariable String id, @RequestBody RestQuery restQuery) {
        System.out.println("Added one: " +  id + " a query to: " + restQuery);
        sWService.createOrUpdate(id, restQuery);
        }
    
    @DeleteMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    void deleteAll(){
        System.out.println("Delete All");
        sWService.deleteAll();
    }
    
    @DeleteMapping("report/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteOne(@PathVariable String id){
               System.out.println("Delete one: " + id);
               sWService.delete(id);
        
    }
    
    
  }
    


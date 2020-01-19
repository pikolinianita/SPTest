/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.SPTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author piko
 */
@Data
@AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
public class ReportSubresult implements Serializable{

   
    @Id
    @GeneratedValue
    @JsonIgnore
    int id;
    
    
    //String report_id;
    @ManyToOne
    @JsonBackReference
    Report report;
    
    String film_id;
    String film_name;
    String character_id;
    String character_name;
    String planet_id;
    String planet_name;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.film_id);
        hash = 29 * hash + Objects.hashCode(this.film_name);
        hash = 29 * hash + Objects.hashCode(this.character_id);
        hash = 29 * hash + Objects.hashCode(this.character_name);
        hash = 29 * hash + Objects.hashCode(this.planet_id);
        hash = 29 * hash + Objects.hashCode(this.planet_name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportSubresult other = (ReportSubresult) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.film_id, other.film_id)) {
            return false;
        }
        if (!Objects.equals(this.film_name, other.film_name)) {
            return false;
        }
        if (!Objects.equals(this.character_id, other.character_id)) {
            return false;
        }
        if (!Objects.equals(this.character_name, other.character_name)) {
            return false;
        }
        if (!Objects.equals(this.planet_id, other.planet_id)) {
            return false;
        }
        if (!Objects.equals(this.planet_name, other.planet_name)) {
            return false;
        }
        return true;
    }
    
    
}

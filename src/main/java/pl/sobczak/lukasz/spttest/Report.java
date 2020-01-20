/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *
 * @author piko
 */
@Data
@AllArgsConstructor
@Entity
@lombok.NoArgsConstructor
public class Report {

    @Id
    //@GeneratedValue
    String report_id;
    @Column(name="q_phrase")
    String query_criteria_character_phrase;
    @Column(name="q_name")
    String query_criteria_planet_name;
    
    @OneToMany(
        mappedBy = "report",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonManagedReference
    Set<ReportSubresult> results;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.report_id);
        hash = 29 * hash + Objects.hashCode(this.query_criteria_character_phrase);
        hash = 29 * hash + Objects.hashCode(this.query_criteria_planet_name);
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
        final Report other = (Report) obj;
        if (!Objects.equals(this.report_id, other.report_id)) {
            return false;
        }
        if (!Objects.equals(this.query_criteria_character_phrase, other.query_criteria_character_phrase)) {
            return false;
        }
        if (!Objects.equals(this.query_criteria_planet_name, other.query_criteria_planet_name)) {
            return false;
        }
        return true;
    }
    
    
}

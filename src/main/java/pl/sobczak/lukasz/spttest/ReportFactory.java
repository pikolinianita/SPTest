/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sobczak.lukasz.spttest;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pl.sobczak.lukasz.spttest.httpClient.HttpReport2;
import pl.sobczak.lukasz.spttest.domain.SWCharacter;
import pl.sobczak.lukasz.spttest.domain.SWFilm;

/**
 *
 * @author piko
 * Generates Report (my entity class) with subReports (char/planet/film data) from 
 * data from HttpClient part.
 * Throws Exception when cannot match people and planet (= when set of subResults is empty)
 * 
 */
@Service
public class ReportFactory {
    
    public Report createReport (String id, HttpReport2 reportHttp){
         
        String planetName = reportHttp.GetPlanetName();
        String planetUrl = reportHttp.getPlanet().getUrl();
        String tmp = planetUrl.substring(0, planetUrl.length()-1);
        String planetId = tmp.substring(tmp.lastIndexOf('/')+1);
        
        var rp = new Report();
        rp.report_id = id;
        rp.query_criteria_character_phrase = reportHttp.getName();
        rp.query_criteria_planet_name = planetName;
        rp.results = new HashSet<>();
        
        Map <String, SWFilm> map = reportHttp
                .getFilmList()
                .stream()
                .collect( Collectors.toMap(SWFilm::getUrl, identity()));
        
        List<SWCharacter> toons = reportHttp.getCharList()
                .stream()
                .filter( (SWCharacter ch) -> ch.getHomeworld().equals(reportHttp.getPlanet().getUrl()))
                .collect(Collectors.toList());
        
        if (toons.isEmpty()) { 
            throw new MyExc.HttpNoCorrectCombination("There is no character with phrase " + reportHttp.getName() + " born on planet " + reportHttp.GetPlanetName());
        }
        
        for(var ch: toons )
             for (var film : ch.getFilms()){
                 var sb = new ReportSubresult();
                 sb.report = rp;
                 sb.character_id = ch.getUrl();
                 sb.character_name = ch.getName();
                sb.film_id = map.get(film).getEpisode_id();
                sb.film_name= map.get(film).getTitle();
                sb.planet_id = planetId;
                sb.planet_name = planetName;
                rp.results.add(sb);
        }
        
        
        return rp;
    }
    
}

package com.example.sbnz.service;

import com.example.sbnz.DTO.Kontinent;
import com.example.sbnz.DTO.RequestDTO;
import com.example.sbnz.DTO.ResponseDTO;
import com.example.sbnz.DTO.StabloMisija;
import com.example.sbnz.model.Country;
import com.example.sbnz.model.Grana;
import com.example.sbnz.model.Region;
import com.example.sbnz.model.SnagaDrzave;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulesService
{
    private final KieContainer kieContainer;
    private ArrayList<Region> regions;
    private ArrayList<Grana> grane;
    private ArrayList<Country> countries;

    public RulesService(KieContainer kieContainer)
    {
        this.kieContainer = kieContainer;

        regions = new ArrayList<Region>();
        regions.add(new Region("Balkan", 250, Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Francuska", 400, Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Pirinejsko poluostrvo", 350, Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Italija", 350, Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Nemacka", 450, Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Bliski Istok", 300, Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Indija", 400, Kontinent.AZIJA));
        regions.add(new Region("Kina", 500, Kontinent.AZIJA));
        regions.add(new Region("Indokina", 300, Kontinent.AZIJA));
        regions.add(new Region("Sibir", 200, Kontinent.AZIJA));
        regions.add(new Region("Severna amerika", 350, Kontinent.NOVI_SVET));
        regions.add(new Region("Juzna amerika", 250, Kontinent.NOVI_SVET));
        regions.add(new Region("Karibi", 150, Kontinent.NOVI_SVET));

        grane = new ArrayList<Grana>();
        grane.add(new Grana("Pirinejsko poluostrvo", "Francuska"));
        grane.add(new Grana("Italija", "Francuska"));
        grane.add(new Grana("Nemacka", "Francuska"));
        grane.add(new Grana("Karibi", "Francuska"));
        grane.add(new Grana("Karibi", "Pirinejsko poluostrvo"));
        grane.add(new Grana("Severna amerika", "Francuska"));
        grane.add(new Grana("Severna amerika", "Karibi"));
        grane.add(new Grana("Juzna amerika", "Karibi"));
        grane.add(new Grana("Balkan", "Italija"));
        grane.add(new Grana("Sibir", "Balkan"));
        grane.add(new Grana("Kina", "Sibir"));
        grane.add(new Grana("Bliski Istok", "Balkan"));
        grane.add(new Grana("Indija", "Bliski Istok"));
        grane.add(new Grana("Kina", "Indija"));
        grane.add(new Grana("Indokina", "Indija"));

        countries = new ArrayList<Country>();
        countries.add(new Country("Srbija", 3, 1, 2, 1, 3, false, StabloMisija.JEDINSTVENO, SnagaDrzave.SLABA, "Balkan"));
        countries.add(new Country("Kastilja", 3, 2, 2, 0, 4, false, StabloMisija.JEDINSTVENO, SnagaDrzave.JAKA, "Pirinejsko poluostrvo"));
        countries.add(new Country("Austrija", 2, 0, 2, 3, 2, true, StabloMisija.JEDINSTVENO, SnagaDrzave.OSREDNJA, "Nemacka"));
        countries.add(new Country("Djenova", 2, 2, 3, 0, 1, false, StabloMisija.GRUPNO, SnagaDrzave.SLABA, "Italija"));
        countries.add(new Country("Ming", 1, 1, 3, 2, 2, true, StabloMisija.JEDINSTVENO, SnagaDrzave.JAKA, "Kina"));
    }

    public ResponseDTO applyRules(RequestDTO request)
    {
        ResponseDTO response = new ResponseDTO();
        Score score = new Score();
        List<Integer> scoreList = new ArrayList<Integer>();

        for(Country country: countries)
        {
            KieSession kieSession = kieContainer.newKieSession();

            kieSession.insert(request);
            kieSession.insert(score);
            kieSession.insert(scoreList);
            kieSession.insert(country);
            for(Region region: regions)
                kieSession.insert(region);
            for(Grana grana: grane)
                kieSession.insert(grana);

            kieSession.fireAllRules();
            kieSession.dispose();

            response.insert(country.ime, score.score);
            scoreList = new ArrayList<Integer>();
        }

        return response;
    }
}

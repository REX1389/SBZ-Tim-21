package com.example.sbnz.service;

import com.example.sbnz.DTO.Kontinent;
import com.example.sbnz.DTO.RequestDTO;
import com.example.sbnz.DTO.ResponseDTO;
import com.example.sbnz.DTO.StabloMisija;
import com.example.sbnz.model.Country;
import com.example.sbnz.model.Region;
import com.example.sbnz.model.SnagaDrzave;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RulesService
{
    private final KieContainer kieContainer;
    private ArrayList<Region> regions;
    private ArrayList<Country> countries;

    public RulesService(KieContainer kieContainer)
    {
        this.kieContainer = kieContainer;

        regions = new ArrayList<Region>();
        regions.add(new Region("Balkan", Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Francuska", Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Pirinejsko poluostrvo", Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Italija", Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Nemacka", Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Bliski Istok", Kontinent.EVROPA_I_SREDOZEMLJE));
        regions.add(new Region("Indija", Kontinent.AZIJA));
        regions.add(new Region("Kina", Kontinent.AZIJA));
        regions.add(new Region("Indokina", Kontinent.AZIJA));
        regions.add(new Region("Sibir", Kontinent.AZIJA));
        regions.add(new Region("Severna amerika", Kontinent.NOVI_SVET));
        regions.add(new Region("Juzna amerika", Kontinent.NOVI_SVET));
        regions.add(new Region("Karibi", Kontinent.NOVI_SVET));

        countries = new ArrayList<Country>();
        countries.add(new Country("Srbija", 3, 1, 2, 1, 3, false, StabloMisija.JEDINSTVENO, SnagaDrzave.SLABA, "Balkan"));
        countries.add(new Country("Kastilja", 3, 2, 2, 0, 4, false, StabloMisija.JEDINSTVENO, SnagaDrzave.JAKA, "Pirinejsko poluostrvo"));
        countries.add(new Country("Austrija", 2, 0, 2, 3, 2, true, StabloMisija.JEDINSTVENO, SnagaDrzave.OSREDNJA, "Nemacka"));
        countries.add(new Country("Djenova", 2, 2, 3, 0, 1, false, StabloMisija.GRUPNO, SnagaDrzave.SLABA, "Italija"));
        countries.add(new Country("Ming", 1, 1, 3, 2, 2, true, StabloMisija.JEDINSTVENO, SnagaDrzave.JAKA, "Kina"));
    }

    public ResponseDTO applyRules(RequestDTO request)
    {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(countries.get(0));
        kieSession.fireAllRules();
        kieSession.dispose();

        return new ResponseDTO("a", "b", "c", "d", "e", 5, 4, 3, 2, 1);
    }
}

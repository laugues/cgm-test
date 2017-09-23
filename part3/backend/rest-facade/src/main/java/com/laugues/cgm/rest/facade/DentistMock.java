package com.laugues.cgm.rest.facade;

import com.laugues.cgm.dto.DentistDTO;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mock to manipulate/create dentist
 */
@Named
@Singleton
public class DentistMock {

    public static final int MAX_DENTIST_NUMBER = 10;

    private List<DentistDTO> dentists;
    private static final List<String> ADJECTIVES = new ArrayList<>();

    static {
        ADJECTIVES.add("cool");
        ADJECTIVES.add("expensive");
        ADJECTIVES.add("cheap");
        ADJECTIVES.add("incompetent");
        ADJECTIVES.add("famous");
        ADJECTIVES.add("pleasant");
        ADJECTIVES.add("brillant");
        ADJECTIVES.add("beautifull");
        ADJECTIVES.add("ugly");
        ADJECTIVES.add("old");
        ADJECTIVES.add("yound");
        ADJECTIVES.add("tall");
        ADJECTIVES.add("small");
        ADJECTIVES.add("unfriendly");

    }

    @PostConstruct
    public  void initMock() {
        dentists = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < MAX_DENTIST_NUMBER; i++) {
            dentists.add(build(i));
        }
    }

    /**
     * Build a {@link DentistDTO} from an increment
     *
     * @param increment the increment
     * @return the dentist built
     */
    private DentistDTO build(int increment) {
        String stringIncrement = String.format("%02d", increment);
        return new DentistDTO()
                .setLogin("dentist" + stringIncrement)
                .setFirstName("firstName" + stringIncrement)
                .setLastName("lastName" + stringIncrement)
                .setDescription("This dentist is " + getAdjective())
                .setImageId(increment + 1);
    }

    private String getAdjective() {
        Integer i = Math.toIntExact(Math.round(ADJECTIVES.size() * Math.random()));
        return ADJECTIVES.get(i);
    }


    public List<DentistDTO> getDentists() {
        return dentists;
    }

    public DentistMock setDentists(List<DentistDTO> dentists) {
        this.dentists = dentists;
        return this;
    }
}

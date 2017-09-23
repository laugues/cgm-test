package com.laugues.cgm.rest.facade;

import com.laugues.cgm.dto.DentistDTO;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@Singleton
public class DentistMock {

    public static final int MAX_DENTIST_NUMBER = 10;

    private List<DentistDTO> dentists;

    @PostConstruct
    private void initMock() {
        dentists = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < MAX_DENTIST_NUMBER; i++) {
            dentists.add(buildFromIncrement(String.format("%02d", i)));
        }
    }

    /**
     * Build a {@link DentistDTO} from an increment
     *
     * @param increment the increment
     * @return the dentist built
     */
    private DentistDTO buildFromIncrement(String increment) {
        return new DentistDTO()
                .setLogin("dentist" + increment)
                .setFirstName("firstName" + increment)
                .setLastName("lastName" + increment);
    }


    public List<DentistDTO> getDentists() {
        return dentists;
    }

    public DentistMock setDentists(List<DentistDTO> dentists) {
        this.dentists = dentists;
        return this;
    }
}

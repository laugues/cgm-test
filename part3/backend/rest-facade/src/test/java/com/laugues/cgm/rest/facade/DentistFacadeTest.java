package com.laugues.cgm.rest.facade;


import com.laugues.cgm.business.entities.DentistEntity;
import com.laugues.cgm.business.service.DentistService;
import com.laugues.cgm.dto.DentistDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DentistFacadeTest {

    @InjectMocks
    private DentistFacade dentistFacade;

    @Mock
    private DentistService dentistServiceMock = mock(DentistService.class);

    @Before
    public void setUp() throws Exception {
        dentistFacade = new DentistFacade() {{
            this.dentistService = dentistServiceMock;
        }};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAll_EmptyList() throws Exception {
        when(dentistServiceMock.findAll()).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), dentistFacade.getAll());
    }

    @Test
    public void testGetAll() throws Exception {
        List<DentistEntity> dentists = new ArrayList<>();
        dentists.add(new DentistEntity().setId(1).setFirstName("Tyron").setLastName("Lannister").setImageId(12));
        dentists.add(new DentistEntity().setId(2).setFirstName("John").setLastName("Doe").setImageId(8));

        when(dentistServiceMock.findAll()).thenReturn(dentists);

        List<DentistDTO> actualDentists = dentistFacade.getAll();

        assertEquals(2, actualDentists.size());
        DentistDTO firstDto = actualDentists.get(0);
        assertEquals(new Integer(1), firstDto.getId());
        assertEquals("Tyron", firstDto.getFirstName());
        assertEquals("Lannister", firstDto.getLastName());
        assertEquals(new Integer(12), firstDto.getImageId());

        DentistDTO secondeDto = actualDentists.get(1);
        assertEquals(new Integer(2), secondeDto.getId());
        assertEquals("John", secondeDto.getFirstName());
        assertEquals("Doe", secondeDto.getLastName());
        assertEquals(new Integer(8), secondeDto.getImageId());
    }

}
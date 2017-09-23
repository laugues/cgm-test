package com.laugues.cgm.rest.facade;


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
    private DentistMock dentistMockTest = mock(DentistMock.class);

    @Before
    public void setUp() throws Exception {
        dentistFacade = new DentistFacade() {{
            this.dentistMock = dentistMockTest;
        }};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAll_EmptyList() throws Exception {
        when(dentistMockTest.getDentists()).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), dentistFacade.getAll());
    }

    @Test
    public void testGetAll() throws Exception {
        List<DentistDTO> dentists = new ArrayList<>();
        dentists.add(new DentistDTO().setFirstName("Tyron").setLastName("Lannister").setDescription("A dwarf")
                .setImageId(12).setLogin("tyron"));
        dentists.add(new DentistDTO().setFirstName("John").setLastName("Doe").setDescription("A dentist").setImageId
                (8).setLogin("john"));

        when(dentistMockTest.getDentists()).thenReturn(dentists);

        List<DentistDTO> actualDentists = dentistFacade.getAll();

        assertEquals(2, actualDentists.size());
        assertEquals("Tyron", actualDentists.get(0).getFirstName());
        assertEquals("Lannister", actualDentists.get(0).getLastName());
        assertEquals("A dwarf", actualDentists.get(0).getDescription());
        assertEquals("tyron", actualDentists.get(0).getLogin());
        assertEquals(new Integer(12), actualDentists.get(0).getImageId());
    }

}
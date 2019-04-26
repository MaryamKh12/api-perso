package org.project.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.model.Volet;
import org.project.service.VoletService;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VoletControllerTest {

    private VoletController voletController;

    @Mock
    private VoletService voletService;

    @Before
    public void setUp(){
        voletController = new VoletController(voletService);
    }


    @Test
    public void addVolet() {
        //When
        Mockito.when(voletService.addVolet(12, "volet", "salon", 10, 1, null)).thenReturn(new Integer(123));

        //Action
        Integer volet = voletController.addVolet(12, "volet", "salon", 10, 1, null);

        //Asserts
        assertEquals(volet, new Integer(123));
    }
}
package org.project.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.project.model.Utilisateur;
import org.project.model.Volet;
import org.project.repository.VoletRepository;
import static org.mockito.Matchers.any;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VoletServiceTest {

    private VoletService voletService;

    @Mock
    private VoletRepository voletRepository;

    @Mock
    private UtilisateurService utilisateurService;



    @Before
    public void setUp(){
        voletService = new VoletService(voletRepository, utilisateurService);
    }

    @Test
    public void should_return_404_on_addVolet_because_user_not_found() {

        //When
        Mockito.when(utilisateurService.findUser(any())).thenReturn(null);

        //Action
        Integer voletNum = voletService.addVolet(123, "volet", "balcon", 90, 0, "ma.ma@gmail.com");

        // Asserts
        assertEquals(voletNum, new Integer(404));
    }

    @Test
    public void should_return_volet_num_on_addVolet() {
        //Given
        Utilisateur utilisateur = new Utilisateur("Maryam", "mail");
        Volet volet = new Volet(123, "volet", "balcon", 90, 0, utilisateur);

        //When
        Mockito.when(utilisateurService.findUser(any())).thenReturn(new Utilisateur("Maryam", "mail"));
        Mockito.when(voletRepository.save(volet)).thenReturn(volet);

        //Action
        Integer voletNum = voletService.addVolet(123, "volet", "balcon", 90, 0, "ma.ma@gmail.com");

        // Asserts
        assertEquals(voletNum, new Integer(123));
    }
}
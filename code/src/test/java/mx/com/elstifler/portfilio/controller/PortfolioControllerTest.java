package mx.com.elstifler.portfilio.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import mx.com.elstifler.portfilio.entity.Owner;
import mx.com.elstifler.portfilio.response.ResponseSuccessful;
import mx.com.elstifler.portfilio.service.PortfolioService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PortfolioService portfolioService;
    @InjectMocks
    private PortfolioController portfolioController;
    @Mock
    private Owner owner;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getOwnerByIdTest(){

        UUID id=UUID.fromString("6407a4f1-d500-4d76-97fc-8de0c90cd54f");
        
        portfolioService = mock(PortfolioService.class);
        when(portfolioService.getOwnerbyId(id)).thenReturn(owner);

        portfolioController = new PortfolioController(portfolioService);

        ResponseEntity<ResponseSuccessful<Owner>> responseEntity= portfolioController.getOwnerById(id);

        assertNotNull(responseEntity);

        
    }

}

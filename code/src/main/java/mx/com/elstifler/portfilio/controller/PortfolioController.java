package mx.com.elstifler.portfilio.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.elstifler.portfilio.entity.Owner;
import mx.com.elstifler.portfilio.response.ResponseSuccessful;
import mx.com.elstifler.portfilio.service.PortfolioService;

@RestController
@RequestMapping("portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService){
        this.portfolioService=portfolioService;
    }
    @GetMapping("/owners/{ownerId}")
    public ResponseEntity<ResponseSuccessful<Owner>> getOwnerById(@PathVariable UUID ownerId){
        Owner owner = portfolioService.getOwnerbyId(ownerId);
        ResponseSuccessful<Owner> responseSuccessful= new ResponseSuccessful<>("200", "proccess successfuly", owner);
        return responseSuccessful.createResponse(HttpStatus.OK);
    }
}

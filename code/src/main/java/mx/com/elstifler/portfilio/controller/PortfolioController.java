package mx.com.elstifler.portfilio.controller;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.elstifler.portfilio.entity.Owner;
import mx.com.elstifler.portfilio.response.ResponseSuccessful;
import mx.com.elstifler.portfilio.service.PortfolioPdfService;
import mx.com.elstifler.portfilio.service.PortfolioService;

@RestController
@RequestMapping("portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final PortfolioPdfService portfolioPdfService;

    public PortfolioController(PortfolioService portfolioService,PortfolioPdfService portfolioPdfService){
        this.portfolioService=portfolioService;
        this.portfolioPdfService=portfolioPdfService;
    }
    @GetMapping("/owners/{ownerId}")
    public ResponseEntity<ResponseSuccessful<Owner>> getOwnerById(@PathVariable UUID ownerId){
        Owner owner = portfolioService.getOwnerbyId(ownerId);
        ResponseSuccessful<Owner> responseSuccessful= new ResponseSuccessful<>("200", "proccess successfuly", owner);
        return responseSuccessful.createResponse(HttpStatus.OK);
    }


 

    @GetMapping("/owners/{ownerId}/pdf/portfolio/download")
    public ResponseEntity<byte[]> downloadCv(){
        ByteArrayOutputStream baos = portfolioPdfService.portfoliPdfDownload();
        HttpHeaders headers = new HttpHeaders();
        
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=mauricio-ramirez-cv.pdf");
        headers.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);

    }
}

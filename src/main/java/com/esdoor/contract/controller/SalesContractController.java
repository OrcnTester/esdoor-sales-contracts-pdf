package com.esdoor.contract.controller;

import com.esdoor.contract.model.SalesContract;
import com.esdoor.contract.service.PdfService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/contracts")
public class SalesContractController {

    private final PdfService pdfService;

    public SalesContractController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/{id}/pdf")
    public String createPdf(@PathVariable String id, @RequestBody SalesContract contract) throws IOException {
        String filePath = "contract-" + id + ".pdf";
        pdfService.generateContractPdf(contract, filePath);
        return "PDF created: " + filePath;
    }
}

package com.esdoor.contract.service;

import com.esdoor.contract.model.SalesContract;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public void generateContractPdf(SalesContract contract, String filePath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            PDType0Font font = PDType0Font.load(document,
                    new File("src/main/resources/fonts/DejaVuSans.ttf"));

            content.setFont(font, 14);
            content.beginText();
            content.newLineAtOffset(50, 750);
            content.showText("Buyer: " + contract.getBuyerName());
            content.newLineAtOffset(0, -20);
            content.showText("Address: " + contract.getAddress());
            content.newLineAtOffset(0, -20);
            content.showText("IBAN: " + contract.getIban());
            content.endText();

            content.close();
            document.save(new FileOutputStream(filePath));
        }
    }
}

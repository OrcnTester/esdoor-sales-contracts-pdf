# Esdoor – Sales Contract PDF API

A Spring Boot service that accepts contract payloads and generates PDF outputs.

## Features
- POST /contracts/{id}/pdf → generate PDF (PDFBox)
- Turkish characters supported via embedded fonts (DejaVu Sans)

## Run
```bash
mvn clean package
java -jar target/esdoor-sales-contract-pdf-0.0.1-SNAPSHOT.jar

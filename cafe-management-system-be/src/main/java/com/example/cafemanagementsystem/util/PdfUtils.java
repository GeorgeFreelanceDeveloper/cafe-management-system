package com.example.cafemanagementsystem.util;

import com.example.cafemanagementsystem.model.dto.BillDto;
import com.example.cafemanagementsystem.model.dto.ReportItemDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.validation.constraints.NotNull;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

public final class PdfUtils {

    private PdfUtils() {

    }

    public static void generateAndSaveBillReport(@NotNull final BillDto billDto,
                                                 @NotNull final String storeLocation)
            throws FileNotFoundException, DocumentException, JsonProcessingException {
        final Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(storeLocation + billDto.uuid() + ".pdf"));

        document.open();
        document.add(createRectangle());
        document.add(createHeader());
        document.add(createDataSection(billDto));
        document.add(createItemsTable(billDto.productDetail()));
        document.add(createFooter(billDto));
        document.close();
    }

    private static Font getFont(final String type) {
        switch (type) {
            case "Header":
                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18, BaseColor.BLACK);
                headerFont.setStyle(Font.BOLD);
                return headerFont;
            case "Data":
                Font dataFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, BaseColor.BLACK);
                dataFont.setStyle(Font.BOLD);
                return dataFont;
            default:
                return new Font();
        }
    }

    private static Rectangle createRectangle() {
        final Rectangle rect = new Rectangle(577, 825, 18, 15);
        rect.enableBorderSide(1);
        rect.enableBorderSide(2);
        rect.enableBorderSide(4);
        rect.enableBorderSide(8);
        rect.setBorderColor(BaseColor.BLACK);
        rect.setBorderWidth(1);
        return rect;
    }

    private static Paragraph createHeader() {
        final Paragraph header = new Paragraph("Cafe Management System", getFont("Header"));
        header.setAlignment(Element.ALIGN_CENTER);
        return header;
    }

    private static Paragraph createDataSection(final BillDto billDto) {
        final String data = String.format(
                "Name: %s \nContact Number: %s \nEmail: %s \nPayment Method: %s \n",
                billDto.name(), billDto.contactNumber(), billDto.email(), billDto.paymentMethod());
        return new Paragraph(data + "\n \n", getFont("Data"));
    }

    private static PdfPTable createItemsTable(final String productDetail) throws JsonProcessingException {
        final PdfPTable table = new PdfPTable(5);

        //Add table header
        Stream.of("Name", "Category", "Quantity", "Price", "Sub Total")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    header.setBackgroundColor(BaseColor.YELLOW);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_CENTER);
                    table.addCell(header);
                });

        //Add rows
        ObjectMapper objectMapper = new ObjectMapper();
        List<ReportItemDto> reportItems = objectMapper.readValue(productDetail, new TypeReference<>() {
        });

        for (ReportItemDto item : reportItems) {
            table.addCell(item.name());
            table.addCell(item.category());
            table.addCell(String.valueOf(item.quantity()));
            table.addCell(String.valueOf(item.price()));
            table.addCell(String.valueOf(item.total()));
        }

        return table;
    }

    private static Paragraph createFooter(@NotNull final BillDto billDto) {
        return new Paragraph(
                String.format("Total : %s \nThank you for visiting. Please visit again!!", billDto.total()),
                getFont("Data"));
    }
}

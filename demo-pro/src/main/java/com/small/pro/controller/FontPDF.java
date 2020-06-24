package com.small.pro.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.io.IOException;

public class FontPDF {

    public static void main(String[] args) throws IOException {
      /*  PDDocument document = PDDocument.load("E:\\test\\pdfbox\\a0-a4.pdf");
        PDPage page = new PDPage(document, 4);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true);
        contentStream.beginText();
        contentStream.setFont(PDTrueTypeFont.loadTTF(document, "C:\\Windows\\Fonts\\SIMYOU.TTF"), 10);
        contentStream.moveTextPositionByAmount(100, 85);
        contentStream.drawString("中文");
        contentStream.endText();
        contentStream.close();

        document.save("E:\\test\\pdfbox\\a0-a4-sign.pdf");
        document.close();*/
    }


}

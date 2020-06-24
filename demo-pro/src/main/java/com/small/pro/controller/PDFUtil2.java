package com.small.pro.controller;


import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.io.IOException;

public class PDFUtil2 {

    public static void main(String[] args) throws IOException
    {
        // Create a new document with an empty page.
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        // Adobe Acrobat uses Helvetica as a default font and
        // stores that under the name '/Helv' in the resources dictionary
        //PDFont font =new PDType1Font("Helvetica");//PDType1Font.HELVETICA
        PDFont font=PDType0Font.load(document, PDFUtil2.class.getResourceAsStream(
                "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), false);
        PDResources resources = new PDResources();
        resources.put(COSName.getPDFName("Helv"), font);

        // Add a new AcroForm and add that to the document
        PDAcroForm acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);

        // Add and set the resources and default appearance at the form level
        acroForm.setDefaultResources(resources);

        // Acrobat sets the font size on the form level to be
        // auto sized as default. This is done by setting the font size to '0'
        String defaultAppearanceString = "/Helv 0 Tf 0 g";
        acroForm.setDefaultAppearance(defaultAppearanceString);

        // Add a form field to the form.
        PDTextField textBox = new PDTextField(acroForm);
        textBox.setPartialName("SampleField");
        // Acrobat sets the font size to 12 as default
        // This is done by setting the font size to '12' on the
        // field level.
        // The text color is set to blue in this example.
        // To use black, replace "0 0 1 rg" with "0 0 0 rg" or "0 g".
        defaultAppearanceString = "/Helv 12 Tf 0 0 1 rg";
        textBox.setDefaultAppearance(defaultAppearanceString);

        // add the field to the acroform
        acroForm.getFields().add(textBox);

        // Specify the widget annotation associated with the field
        PDAnnotationWidget widget = textBox.getWidgets().get(0);
        PDRectangle rect = new PDRectangle(50, 750, 200, 50);
        widget.setRectangle(rect);
        widget.setPage(page);

        // set green border and yellow background
        // if you prefer defaults, delete this code block
        PDAppearanceCharacteristicsDictionary fieldAppearance
                = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
        fieldAppearance.setBorderColour(new PDColor(new float[]{0,1,0}, PDDeviceRGB.INSTANCE));
        fieldAppearance.setBackground(new PDColor(new float[]{1,1,0}, PDDeviceRGB.INSTANCE));
        widget.setAppearanceCharacteristics(fieldAppearance);

        // make sure the widget annotation is visible on screen and paper
        widget.setPrinted(true);

        // Add the widget annotation to the page
        page.getAnnotations().add(widget);

        // set the field value
        textBox.setValue("zhangsan");

        // put some text near the field
        PDPageContentStream cs = new PDPageContentStream(document, page);
        cs.beginText();
        cs.setFont(font, 15);
        cs.newLineAtOffset(50, 810);
        cs.showText("Field:");
        cs.endText();
        cs.close();

        document.save("D:/aa/SimpleForm.pdf");
        document.close();
    }

 /*   public static void main(String[] args)throws IOException {

        // Create a new document with an empty page.
        try (PDDocument doc = new PDDocument())
        {
            PDPage page = new PDPage();
            doc.addPage(page);
            PDAcroForm acroForm = new PDAcroForm(doc);
            doc.getDocumentCatalog().setAcroForm(acroForm);

            // Note that the font is fully embedded. If you use a different font, make sure that
            // its license allows full embedding.
            PDFont formFont = PDType0Font.load(doc, PDFUtil2.class.getResourceAsStream(
                    "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), false);

            // Add and set the resources and default appearance at the form level
            final PDResources resources = new PDResources();
            acroForm.setDefaultResources(resources);
            final String fontName = resources.add(formFont).getName();

            // Acrobat sets the font size on the form level to be
            // auto sized as default. This is done by setting the font size to '0'
            acroForm.setDefaultResources(resources);
            String defaultAppearanceString = "/" + fontName + " 0 Tf 0 g";

            PDTextField textBox = new PDTextField(acroForm);
            textBox.setPartialName("SampleField");
            textBox.setDefaultAppearance(defaultAppearanceString);
            acroForm.getFields().add(textBox);

            // Specify the widget annotation associated with the field
            PDAnnotationWidget widget = textBox.getWidgets().get(0);
            PDRectangle rect = new PDRectangle(50, 700, 200, 50);
            widget.setRectangle(rect);
            widget.setPage(page);
            page.getAnnotations().add(widget);

            // set the field value. Note that the last character is a turkish capital I with a dot,
            // which is not part of WinAnsiEncoding
            textBox.setValue("Sample field 陌");

            doc.save("D:/aa/PDFUtil2.pdf");
        }
    }
*/


}

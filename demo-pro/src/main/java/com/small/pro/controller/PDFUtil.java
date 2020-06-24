package com.small.pro.controller;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFUtil {


    public static void main(String[] args)throws IOException {
        PDFUtil  pdfUtil=new  PDFUtil();
        //pdfUtil.printFields(PDDocument.load(new File( "D://aa//SimpleForm.pdf")));
        pdfUtil.getPdfFile();
    }
    public void printFields(PDDocument pdfDocument) throws IOException
    {
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List<PDField> fields = acroForm.getFields();

        System.out.println(fields.size() + " top-level fields were found on the form");

        for (PDField field : fields)
        {
            System.out.println("name:"+field.getPartialName());
            System.out.println("name:"+field.getValueAsString());
            processField(field, "|--", field.getPartialName());
        }
    }

    private void processField(PDField field, String sLevel, String sParent) throws IOException
    {
        String partialName = field.getPartialName();

        if (field instanceof PDNonTerminalField)
        {
            if (!sParent.equals(field.getPartialName()) && partialName != null)
            {
                sParent = sParent + "." + partialName;
            }
            System.out.println(sLevel + sParent);

            for (PDField child : ((PDNonTerminalField)field).getChildren())
            {
                processField(child, "|  " + sLevel, sParent);
            }
        }
        else
        {
            String fieldValue = field.getValueAsString();
            StringBuilder outputString = new StringBuilder(sLevel);
            outputString.append(sParent);
            if (partialName != null)
            {
                outputString.append(".").append(partialName);
            }
            outputString.append(" = ").append(fieldValue);
            outputString.append(",  type=").append(field.getClass().getName());
            System.out.println(outputString);
        }
    }



    public  void  getPdfFile () throws IOException
    {
        String formTemplate = "D:/aa/MultiWidgetsForm.pdf";

        // load the document
        PDDocument pdfDocument = PDDocument.load(new File(formTemplate));

        // get the document catalog
        PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

     /*   PDFont formFont = PDType0Font.load(pdfDocument, PDFUtil.class.getResourceAsStream(
                "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), false);
*/
        // Add and set the resources and default appearance at the form level
     /*   final PDResources resources = new PDResources();
        acroForm.setDefaultResources(resources);
        final String fontName = resources.add(formFont).getName();
        acroForm.setDefaultResources(resources);*/
        // as there might not be an AcroForm entry a null check is necessary
        if (acroForm != null)
        {
            // Retrieve an individual field and set its value.
            PDTextField username = (PDTextField) acroForm.getField( "SampleField" );
            username.setValue("Sample field");
           /* PDTextField age= (PDTextField) acroForm.getField( "age" );
            age.setValue("28");*/
            // If a field is nested within the form tree a fully qualified name
            // might be provided to access the field.
          /*  field = (PDTextField) acroForm.getField( "fieldsContainer.nestedSampleField" );
            field.setValue("Text Entry");*/
        }

        // Save and close the filled out form.
        pdfDocument.save("D:/aa/MultiWidgetsForm2.pdf");
        pdfDocument.close();
    }





}

package mx.com.elstifler.portfilio.service.implement;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

// import com.itextpdf.kernel.colors.Color;
// import com.itextpdf.kernel.colors.DeviceRgb;
// import com.itextpdf.kernel.geom.PageSize;
// import com.itextpdf.kernel.geom.Rectangle;
// import com.itextpdf.kernel.pdf.PdfDocument;
// import com.itextpdf.kernel.pdf.PdfWriter;
// import com.itextpdf.layout.Document;
// import com.itextpdf.layout.element.Paragraph;
// import com.itextpdf.layout.element.Text;
import com.lowagie.text.Document;
import com.lowagie.text.Anchor;
import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.*;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;

import mx.com.elstifler.portfilio.service.PortfolioPdfService;

@Service
public class PortfolioPdfServiceImp implements PortfolioPdfService {



    @Override
    public ByteArrayOutputStream portfoliPdfDownload() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Define colors
            Color darkGray = new Color(47, 79, 79);
            Color blue = new Color(70, 130, 180);
            Color white = Color.WHITE;
            Color lightGray = new Color(240, 240, 240);
            Color ligthGreen = new Color(50, 175, 178);

            // Define fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, ligthGreen);
            Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLACK);
            Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);
            Font boldTextFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLACK);
            Font boldSecundaryTextFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, ligthGreen);

            // Agregar el título directamente al documento

            PdfPTable tableTitle = new PdfPTable(2);
            tableTitle.setWidthPercentage(100);
            tableTitle.setWidths(new float[] { 1, 2 });
            PdfPTable leftTitleTable = new PdfPTable(1);
            leftTitleTable.setWidthPercentage(100);

            PdfPCell leftTitleCell = new PdfPCell(leftTitleTable);
            leftTitleCell.setBorder(Rectangle.NO_BORDER);
            tableTitle.addCell(leftTitleCell);

            // Right column
            PdfPTable rightTitleTable = new PdfPTable(1);
            rightTitleTable.setWidthPercentage(100);

            PdfPCell cellOwner = new PdfPCell();
            cellOwner.setBorder(Rectangle.NO_BORDER);
            Paragraph titlePositionL = new Paragraph("JAVA DEVELOPER", titleFont);
            Paragraph titleOwnerNameL = new Paragraph("MAURICIO RAMIREZ", titleFont);
            titlePositionL.setAlignment(Element.ALIGN_CENTER);
            titleOwnerNameL.setAlignment(Element.ALIGN_CENTER);
            cellOwner.addElement(titlePositionL);
            cellOwner.addElement(titleOwnerNameL);
            rightTitleTable.addCell(cellOwner);

            PdfPCell rightTitleCell = new PdfPCell(rightTitleTable);
            rightTitleCell.setBorder(Rectangle.NO_BORDER);
            tableTitle.addCell(rightTitleCell);

            // Add main table to document
            document.add(tableTitle);

            document.add(new Paragraph("\n"));

            // Table for left and right columns
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new float[] { 1, 2 });

            // Left column
            PdfPTable leftTable = new PdfPTable(1);
            leftTable.setWidthPercentage(100);

            // Contact Information
            leftTable.addCell(createCell("Phone: 6691381479", boldSecundaryTextFont, lightGray));
            leftTable.addCell(createCell("6691381479", textFont, lightGray));
            leftTable.addCell(createCell("Email: ", boldSecundaryTextFont, lightGray));
            leftTable.addCell(
                    createLinkCell("mauricio.develop@gmail.com", "mauricio.develop@gmail.com", textFont, lightGray));
            leftTable.addCell(createCell("LinkedIn:", boldSecundaryTextFont, lightGray));
            leftTable.addCell(createLinkCell("https://www.linkedin.com/in/mauricio-ramirez-develop/",
                    "https://www.linkedin.com/in/mauricio-ramirez-develop/", textFont, lightGray));

            // Skills section
            leftTable.addCell(createCell("Skills", sectionFont, lightGray));
            leftTable.addCell(createCell("Software Development:", boldSecundaryTextFont, lightGray));
            leftTable.addCell(createCell("Java EE, EJB, Spring Boot, MVC, Hibernate", textFont, lightGray));
            leftTable.addCell(createCell("Database:", boldSecundaryTextFont, lightGray));
            leftTable.addCell(createCell("MYSQL, ASE SQL", textFont, lightGray));
            leftTable.addCell(createCell("Others:", boldSecundaryTextFont, lightGray));
            leftTable.addCell(createCell("Team work, Adaptation to change, Empathy", textFont, lightGray));

            // Add left table to main table
            PdfPCell leftCell = new PdfPCell(leftTable);
            leftCell.setBorder(Rectangle.NO_BORDER);
            table.addCell(leftCell);

            // Right column
            PdfPTable rightTable = new PdfPTable(1);
            rightTable.setWidthPercentage(100);

            // About Me section
            PdfPCell aboutMeCell = new PdfPCell(new Phrase("About Me", sectionFont));
            aboutMeCell.setBackgroundColor(lightGray);
            aboutMeCell.setBorder(Rectangle.NO_BORDER);
            rightTable.addCell(aboutMeCell);

            PdfPCell aboutMeTextCell = new PdfPCell(new Phrase(
                    "I am a Java Developer with more than two years of experience in software development for the financial sector. I adapt very well to changes and teamwork.",
                    textFont));
            aboutMeTextCell.setBorder(Rectangle.NO_BORDER);
            rightTable.addCell(aboutMeTextCell);

            // Work Experience section
            rightTable.addCell(createCell("Work Experience", sectionFont, lightGray));
            rightTable.addCell(createCell("Java Developer", boldTextFont, white));
            rightTable.addCell(createLinkCell("https://stefanini.com/es", "Stefanini Latam. | Feb 2022 - Dec 2022",textFont, white));
            rightTable.addCell(createCell(
                    "Create and Optimize RESTful Services with Java 8. Version management with Git. Use of SCRUM Methodology for software development. Analysis and Troubleshooting in Production.",
                    textFont, white));

            rightTable.addCell(createCell("Junior Java Developer", boldTextFont, white));
            rightTable.addCell(createLinkCell("https://www.solemtipyme.com/", "Solemti Aug 2021 - Dec 2021", textFont,white));
            rightTable.addCell(createCell(
                    "Create and Optimize RESTful Services with Java 8 and 11. Migrating Java Web Services to Spring. Using Hibernate for Data Persistence. Version Management with Git (Github and Gitlab). Use of SCRUM Methodology for software development.",
                    textFont, white));

            rightTable.addCell(createCell("Programmer Analyst", boldTextFont, white));
            rightTable.addCell(createLinkCell("https://www.banregio.com/", "Banregio. | Jan 2019 - May 2021", textFont,white));


            // Crear una lista con viñetas
            List list = new List(List.UNORDERED);
            list.setListSymbol("\u2022");
            list.setIndentationLeft(20); 
            list.add(new ListItem("Software Development in Java EE Java 8 (EJB)"));
            list.add(new ListItem("Requirement Analysis"));
            list.add(new ListItem("Use of Hibernate for Data Persistence."));
            list.add(new ListItem("Process Management in ASE SQL Database (store procedure, tables, querys)."));
            list.add(new ListItem("Version Management with Git (Bitbucket)."));
            list.add(new ListItem("Use of SCRUM Methodology for software development"));
            rightTable.addCell(createCellList(list, boldSecundaryTextFont, white));

            // Education section
            rightTable.addCell(createCell("Education", sectionFont, lightGray));
            rightTable.addCell(createCell("Universidad Politécnica de Sinaloa (UPSIN)", boldTextFont, white));
            rightTable.addCell(createCell("Computer Engineering | 2015 - 2018", textFont, white));

            // Languages section
            rightTable.addCell(createCell("Languages", sectionFont, lightGray));
            rightTable.addCell(createCell("English A2", textFont, white));

            // Add right table to main table
            PdfPCell rightCell = new PdfPCell(rightTable);
            rightCell.setBorder(Rectangle.NO_BORDER);
            table.addCell(rightCell);

            // Add main table to document
            document.add(table);

        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return baos;
    }

    private PdfPCell createCell(String text, Font font, Color backgroundColor) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(backgroundColor);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
    private PdfPCell createCellList(List list, Font font, Color backgroundColor) {
        
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(backgroundColor);
        cell.addElement(list);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    private PdfPCell createLinkCell(String link, String title, Font font, Color backgroundColor) {
        PdfPCell cell = new PdfPCell();

        Anchor anchor = new Anchor(title, font);
        anchor.setReference(link);

        Phrase phrase = new Phrase();
        phrase.add(anchor);

        cell.setBackgroundColor(backgroundColor);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.addElement(phrase);
        return cell;
    }
}

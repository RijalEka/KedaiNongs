import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReceiptGenerator {
    public void generateReceipt(String content, String fileName) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            document.add(new Paragraph(content));
            document.close();
            System.out.println("Struk berhasil dicetak.");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReceiptGenerator rg = new ReceiptGenerator();
        String content = "Kedai Nongs\nPesanan: Nasi Goreng\nTotal: 15000\nTerima Kasih!";
        rg.generateReceipt(content, "struk.pdf");
    }
}

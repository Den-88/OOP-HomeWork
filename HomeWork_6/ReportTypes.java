import java.util.HashMap;
import java.util.Map;

public class ReportTypes {

    protected static Map<String, ReportGenerator> reportGenerators = new HashMap<>();

    static {
        reportGenerators.put("PDF", new PdfReportGenerator());
        reportGenerators.put("PDF2", new AnotherPdfReportGenerator());
        reportGenerators.put("JSON", new JsonReportGenerator());
        reportGenerators.put("XML", new XmlReportGenerator());
    }
}
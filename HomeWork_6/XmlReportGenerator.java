public class XmlReportGenerator implements ReportGenerator {

    @Override
    public Report generateReport(Document document) {
        System.out.println("Генерация XML-отчета...");
        // Логика генерации XML-отчета
        return new Report("XML-отчет".getBytes());
    }
}
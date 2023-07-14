public class JsonReportGenerator implements ReportGenerator {

    @Override
    public Report generateReport(Document document) {
        System.out.println("Генерация JSON-отчета...");
        // Логика генерации JSON-отчета
        return new Report("JSON-отчет".getBytes());
    }
}
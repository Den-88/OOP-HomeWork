public class PdfReportGenerator implements ReportGenerator {

    @Override
    public Report generateReport(Document document) {
        System.out.println("Генерация PDF-отчета...");
        // Логика генерации PDF-отчета
        return new Report("PDF-отчет".getBytes());
    }
}
public class AnotherPdfReportGenerator extends PdfReportGenerator {

    @Override
    public Report generateReport(Document document) {
        System.out.println("Генерация PDF-отчета с другой разметкой...");
        // Логика генерации PDF-отчета с другой разметкой
        return new Report("PDF-отчет с другой разметкой".getBytes());
    }
}
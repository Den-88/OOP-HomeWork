/**
     * Класс документ - описывает документ.
     *
     * Нужно спроектировать подсистему отчетов, которая будет формировать отчеты для документа.
     * document -> report
     * 1. Формирование PDF-файла (потенциально может быть несколько видов разметки этого PDF-файла).
     * 2. Создание JSON-файла с полями документа
     * 3. Создание XML-файла с полями документа
     * 4. ... потенциально отчеты могут добавляться.
     *
     * После реализации задать себе 2 вопроса:
     * 1. Насколько сложно добавить поддержку нового типа отчета?
     * 2. Как будет выглядеть проект, если типов отчетов будет 1000+?
     */

import java.util.UUID;

public class Homework {

    public static void main(String[] args) {
        Document myDoc = new Document(UUID.randomUUID(), "1195", "Какой-то документ", "Какой-то текст документа");
        Report myReportPdfOne = ReportEntrypoint.create(myDoc, "PDF");
        Report myReportPdfTwo = ReportEntrypoint.create(myDoc, "PDF2");
        Report myReportJson = ReportEntrypoint.create(myDoc, "JSON");
        Report myReportXml = ReportEntrypoint.create(myDoc, "XML");
        // ...
    }
}

package adapters;

public class RelatorioAdapter implements ReportAdapter {
    private ExternalReportGenerator externalReportGenerator;

    public RelatorioAdapter(ExternalReportGenerator externalReportGenerator) {
        this.externalReportGenerator = externalReportGenerator;
    }

    @Override
    public void addReport(String title, String description, String creationDate, String author) {
        // Supondo que o formato seja PDF
        String reportContent = String.format("Report Title: %s\nDescription: %s\nCreated on: %s\nAuthor: %s",
                title, description, creationDate, author);
        externalReportGenerator.generateReport(title, reportContent, "PDF");
    }
}

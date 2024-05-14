package adapters;

public interface ExternalReportGenerator {
    String generateReport(String title, String content, String format);
}
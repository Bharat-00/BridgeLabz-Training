// Interface with default JSON export
interface DataExporter {
    void exportCSV();
    void exportPDF();
    // Newly added default JSON export
    default void exportJSON() {
        System.out.println("Exporting data in JSON format");
    }
}
class ReportExporter implements DataExporter {
    public void exportCSV() {
        System.out.println("Exporting data in CSV format");
    }
    public void exportPDF() {
        System.out.println("Exporting data in PDF format");
    }
}
public class DataExportApplication {
    public static void main(String[] args) {
        DataExporter exporter = new ReportExporter();
        exporter.exportCSV();
        exporter.exportPDF();
        exporter.exportJSON();
    }
}

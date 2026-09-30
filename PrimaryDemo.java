package com.santhosh.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface ReportService {
    void generate();
}

@Component
@Primary
class PdfReportService implements ReportService {
    public void generate() {
        System.out.println("PDF report generated");
    }
}

@Component
class ExcelReportService implements ReportService {
    public void generate() {
        System.out.println("Excel report generated");
    }
}

@Component
class ReportController {
    private final ReportService reportService;

    ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    void createReport() {
        reportService.generate();
    }
}

@Configuration
@ComponentScan("com.santhosh.springcore")
class PrimaryConfig {
}

public class PrimaryDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PrimaryConfig.class);
        context.getBean(ReportController.class).createReport();
        context.close();
    }
}

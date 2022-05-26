package com.app.banking.controller;

import com.app.banking.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.app.banking.URLMapping.REPORTS;

@RestController
@RequestMapping(REPORTS)
@RequiredArgsConstructor
public class ReportController {
    public final ReportService reportService;

//    @GetMapping()
//    public byte[] exportReport(@PathVariable String type, HttpServletResponse response) throws IOException {
//        ReportType reportType = ReportType.valueOf(type);
//
//        return reportServiceFactory.getReportService(reportType).export(response);
//    }
}

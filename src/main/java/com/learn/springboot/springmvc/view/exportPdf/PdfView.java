package com.learn.springboot.springmvc.view.exportPdf;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 16:07
 * @modified By:
 * @description:导出视图类
 */
public class PdfView extends AbstractPdfView {

    private PdfExportService pdfExportService;

    public PdfView(PdfExportService pdfExportService) {
        this.pdfExportService = pdfExportService;
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        pdfExportService.make(map,document,pdfWriter,httpServletRequest,httpServletResponse);
    }
}

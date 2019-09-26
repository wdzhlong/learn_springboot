package com.learn.springboot.springmvc.view.exportPdf;


import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 16:04
 * @modified By:
 * @description:各个控制器都会有不同的导出逻辑。为了适应不同控制器的自定义导出，先定义展出的接口
 */
public interface PdfExportService {

    public void make(Map<String, Object> model, Document document, PdfWriter writer,
                     HttpServletRequest request, HttpServletResponse response);
}

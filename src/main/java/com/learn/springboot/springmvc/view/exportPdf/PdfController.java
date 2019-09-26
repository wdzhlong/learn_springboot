package com.learn.springboot.springmvc.view.exportPdf;

import com.learn.springboot.mybatis.dao.MybatisUserDao;
import com.learn.springboot.mybatis.entity.User;
import com.lowagie.text.Chunk;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.awt.*;
import java.util.List;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 16:13
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private MybatisUserDao mybatisUserDao = null;

    @RequestMapping("/exportPdf")
    public ModelAndView exportPdf(){
        List<User> userList = mybatisUserDao.findAll();
        View pdfView = new PdfView(exportService());
        ModelAndView mv = new ModelAndView();
        mv.setView(pdfView);
        mv.addObject("userList",userList);
        return mv;
    }

    private PdfExportService exportService(){
        return ((model, document, writer, request, response) -> {
            try {
                // 设置纸张大小
                document.setPageSize(PageSize.A4);
                // 标题
                document.addTitle("用户信息");
                // 换行
                document.add(new Chunk("\n"));
                // 表格三列
                PdfPTable table = new PdfPTable(3);
                // 单元格
                PdfPCell cell = null;

                Font f8 = new Font();
                f8.setColor(Color.BLUE);
                f8.setStyle(Font.BOLD);

                //标题
                cell = new PdfPCell(new Paragraph("id",f8));
                // 居中对齐
                cell.setHorizontalAlignment (1);
                // 将单元格加入表格
                table.addCell (cell);
                cell= new PdfPCell(new Paragraph ("userName", f8)) ;
                //居中对齐
                cell.setHorizontalAlignment (1);
                table.addCell (cell) ;
                cell= new PdfPCell (new Paragraph ("note", f8));
                cell . setHorizontalAlignment(1);
                table.addCell(cell) ;
                // 获取数据模型中的用户列表
                List<User> userList= (List<User>) model.get("userList");
                for (User user : userList) {
                    document.add(new Chunk("\n"));
                    cell = new PdfPCell(new Paragraph(user.getId()));
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(user.getUserName()));
                    table.addCell(cell);
                    String note = user.getNote() == null ? "" : user.getNote();
                    cell = new PdfPCell(new Paragraph(note));
                    table.addCell(cell);
                    // 在文档中加入表格
                    document.add(table);
                }
            }catch (Exception e){

            }
        });
    }
}

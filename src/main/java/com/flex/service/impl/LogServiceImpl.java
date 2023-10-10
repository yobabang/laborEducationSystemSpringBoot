package com.flex.service.impl;

import com.flex.dao.LogDao;
import com.flex.domain.Log;
import com.flex.domain.User;
import com.flex.pojo.dto.StudentLogScoreDto;
import com.flex.service.LogService;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public boolean save(Log log) {
        return logDao.save(log) > 0;
    }


    @Override
    public boolean delete(Integer id) {
        return logDao.delete(id) > 0;
    }

    @Override
    public Log getById(Integer id) {
        return logDao.getById(id);
    }

    @Override
    public List<Log> getAll() {
        return logDao.getAll();
    }

    @Override
    public List<Log> getLogByClassType(String className, Integer logType) {
        return logDao.getLogByClassType(className,logType);
    }

    @Override
    public List<StudentLogScoreDto> getStuScoreByClass(String className) {
        return logDao.getStuScoreByClass(className);
    }

    @Override
    public void createLogByUserId(User user) {

    }

    @Override
    public String createLogFile(Log log) {
        XWPFDocument document = new XWPFDocument();

        String fileName = log.getUserId() + "log" + log.getLogType();

        // 创建段落，添加到文档中
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun titleRun = paragraph.createRun();
        titleRun.setText("劳动日志"); // 设置标题
        titleRun.setBold(true);
        titleRun.setFontSize(16);

        //居中
        paragraph.setAlignment(ParagraphAlignment.CENTER);

        // 创建带边框的段落来模拟文本框
        XWPFParagraph textBoxParagraph = document.createParagraph();
        textBoxParagraph.setBorderBottom(Borders.SINGLE); // 设置底部边框
        textBoxParagraph.setBorderLeft(Borders.SINGLE);   // 设置左边边框
        textBoxParagraph.setBorderRight(Borders.SINGLE);  // 设置右边边框
        textBoxParagraph.setBorderTop(Borders.SINGLE);    // 设置顶部边框
        textBoxParagraph.setSpacingAfter(10); // 设置段落之间的间距

        // 添加属性内容到文本框段落
        XWPFRun textBoxRun = textBoxParagraph.createRun();
        for (java.lang.reflect.Field field : log.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                String fieldValue = String.valueOf(field.get(log));
                textBoxRun.setText(fieldName + ": " + fieldValue);
                textBoxRun.addBreak(); // 换行
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // 保存文档为Word文件
        try (FileOutputStream out = new FileOutputStream("./file/" + fileName + ".docx")) {
            document.write(out);
            System.out.println("Word文件生成成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }


}

package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.service.MdToHtmlService;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MdToHtmlServiceImpl implements MdToHtmlService {
    @Override
    public String convert(String md) {
        MutableDataSet options = new MutableDataSet();

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(md);
        String htmlOutPut = renderer.render(document);

        Pattern p = Pattern.compile("<\\s*input[\\S\\s]*?>|<\\s*form[\\S\\s]*?>|<\\s*script[\\S\\s]*?>|<\\s*button[\\S\\s]*>|<\\s*iframe[\\S\\s]*>|<\\s*nav[\\S\\s]*>|<\\s*meta[\\S\\s]*>");
        Matcher m = p.matcher(htmlOutPut);

        htmlOutPut = m.replaceAll("&lt;some tag&gt;");
        return htmlOutPut;
    }
}

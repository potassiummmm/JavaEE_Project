package com.tongji.springbootdemo.service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import com.vladsch.flexmark.html2md.converter.HtmlConverterCoreNodeRendererFactory;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MdToHtml {
    public static String convert(String md) {
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


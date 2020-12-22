package com.tongji.springbootdemo.service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;


public class MdToHtml {
    public static String convert(String md) {
        String escapeMd = md.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
        System.out.println(escapeMd);
        
        MutableDataSet options = new MutableDataSet();
        
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        
        // You can re-use parser and renderer instances
        Node document = parser.parse(escapeMd);
        String htmlOutPut = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        htmlOutPut = htmlOutPut.replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
        return htmlOutPut;
    }
    
    public static void main(String[] args) {
        String aa = "&lt;";
        String bb = MdToHtml.convert(aa);
        System.out.println(bb);
    }
}
package com.tongji.springbootdemo.service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;


public class MdToHtml {
    public static String convert(String md) {
        String escapeMd = md.replace("<", "&lt;")
                            .replace(">", "&gt;")
                            .replace("&", "&amp;");

        MutableDataSet options = new MutableDataSet();

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(escapeMd);
        String htmlOutPut = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        htmlOutPut = htmlOutPut.replace("&lt;", "<")
                               .replace("&gt;", ">")
                               .replace("&amp;", "&");
        return htmlOutPut;
    }
}

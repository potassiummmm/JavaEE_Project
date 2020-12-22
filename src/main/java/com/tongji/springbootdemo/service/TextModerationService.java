package com.tongji.springbootdemo.service;

import java.util.HashMap;

public interface TextModerationService {
    HashMap<String, String> toMap(String content);

    boolean isValid(String content);
}

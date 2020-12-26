package com.tongji.springbootdemo.service.impl;

import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.tms.v20200713.TmsClient;
import com.tencentcloudapi.tms.v20200713.models.*;
import com.tongji.springbootdemo.service.TextModerationService;
import org.springframework.stereotype.Service;;import java.io.StringReader;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class TextModerationImpl implements TextModerationService {
    @Override
    public HashMap<String, String> toMap(String content) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            Credential cred = new Credential("SECRETID", "SECRETKEY");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            TmsClient client = new TmsClient(cred, "ap-shanghai", clientProfile);

            TextModerationRequest req = new TextModerationRequest();
            Base64.Encoder encoder = Base64.getEncoder();
            String base64Content = encoder.encodeToString(content.getBytes());
            req.setContent(base64Content);

            TextModerationResponse resp = client.TextModeration(req);
            resp.toMap(map, "");
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return map;
    }

    @Override
    public boolean isValid(String content) {
        TextModerationImpl textModeration = new TextModerationImpl();
        HashMap<String, String> map = textModeration.toMap(content);
        return map.get("Label").equals("Normal");
    }
}

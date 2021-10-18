package com.whynotyue.community.strategy;

import org.springframework.stereotype.Component;

@Component
public class ImageExportStrategy extends ExportStrategy {

    @Override
    public String export() {
        // ...
        return "image导出完毕！";
    }
}

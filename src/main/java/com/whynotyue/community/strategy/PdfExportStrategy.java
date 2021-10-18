package com.whynotyue.community.strategy;

import org.springframework.stereotype.Component;

@Component
public class PdfExportStrategy extends ExportStrategy {

    @Override
    public String export() {
        // ...
        return "pdf导出完毕！";
    }
}
package com.whynotyue.community.strategy;

import org.springframework.stereotype.Component;

@Component
public class ExcelExportStrategy extends ExportStrategy {

    @Override
    public String export() {
        // ...
        return "excel导出完毕！";
    }
}

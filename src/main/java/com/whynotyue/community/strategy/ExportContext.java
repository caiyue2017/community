package com.whynotyue.community.strategy;

public class ExportContext {

    private ExportStrategy exportStrategy;

    public ExportContext(String type) throws ClassNotFoundException {
        this.exportStrategy = (ExportStrategy) ExportBeanFactory.getBean(type + "ExportStrategy");
    }

    public String export() {
        return this.exportStrategy.export();
    }

}

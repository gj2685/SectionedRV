package com.dev.sectionedrv;


import java.util.List;

public class SectionedData {
    private String headerName;
    private List<Model> modelList;

    public SectionedData(String headerName, List<Model> modelList) {
        this.headerName = headerName;
        this.modelList = modelList;
    }

    public String getHeaderName() {
        return headerName;
    }

    public List<Model> getModelList() {
        return modelList;
    }
}

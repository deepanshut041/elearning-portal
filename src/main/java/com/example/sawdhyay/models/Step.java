package com.example.sawdhyay.models;

public class Step {
    private String title;
    private Module module;
    private String type;
    private String detail;

    public Step() {
    }

    public Step(String title, Module module, String type, String detail) {
        this.title = title;
        this.module = module;
        this.type = type;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

package com.kingyzll.addviewdemo;

public class Bean {
    private String tilte;
    private String content;

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bean(String tilte, String content) {
        this.tilte = tilte;
        this.content = content;
    }
}

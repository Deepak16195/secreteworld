package com.credosys.solutions.secrete.world.Pojos;

/**
 * Created by win7 on 12-Jan-18.
 */

public class Messages {
    private String name;
    private String content;

    public Messages(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

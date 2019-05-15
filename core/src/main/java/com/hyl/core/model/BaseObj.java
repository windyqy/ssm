package com.hyl.core.model;

import java.io.Serializable;

public class BaseObj  implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

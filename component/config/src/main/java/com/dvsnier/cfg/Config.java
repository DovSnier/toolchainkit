package com.dvsnier.cfg;

/**
 * the Config info
 * Created by dovsnier on 2020/8/4.
 */
public enum Config {

    VERSION_NAME("version_name"), BUILD_TYPE("build_type"),
    FIRST_TIME("first_time"), RECENTLY_TIME("recently_time");

    protected String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Config{" +
                "value='" + value + '\'' +
                '}';
    }
}

package com.dvsnier.cfg;

/**
 * the sdk key - value
 * Created by dovsnier on 2020/8/4.
 */
public class Attribute {

    private String keyOfVersionName;
    private String keyOfBuildType;
    private String keyOfFirstTime;
    private String keyOfRecentlyTime;
    private String valueOfVersionName;
    private String valueOfBuildType;
    private String valueOfFirstTime;
    private String valueOfRecentlyTime;

    private Attribute() {
    }

    public String getKeyOfVersionName() {
        return keyOfVersionName;
    }

    private void setKeyOfVersionName(String keyOfVersionName) {
        this.keyOfVersionName = keyOfVersionName;
    }

    public String getKeyOfBuildType() {
        return keyOfBuildType;
    }

    private void setKeyOfBuildType(String keyOfBuildType) {
        this.keyOfBuildType = keyOfBuildType;
    }

    public String getKeyOfFirstTime() {
        return keyOfFirstTime;
    }

    private void setKeyOfFirstTime(String keyOfFirstTime) {
        this.keyOfFirstTime = keyOfFirstTime;
    }

    public String getKeyOfRecentlyTime() {
        return keyOfRecentlyTime;
    }

    private void setKeyOfRecentlyTime(String keyOfRecentlyTime) {
        this.keyOfRecentlyTime = keyOfRecentlyTime;
    }

    public String getValueOfVersionName() {
        return valueOfVersionName;
    }

    public void setValueOfVersionName(String valueOfVersionName) {
        this.valueOfVersionName = valueOfVersionName;
    }

    public String getValueOfBuildType() {
        return valueOfBuildType;
    }

    public void setValueOfBuildType(String valueOfBuildType) {
        this.valueOfBuildType = valueOfBuildType;
    }

    public String getValueOfFirstTime() {
        return valueOfFirstTime;
    }

    public void setValueOfFirstTime(String valueOfFirstTime) {
        this.valueOfFirstTime = valueOfFirstTime;
    }

    public String getValueOfRecentlyTime() {
        return valueOfRecentlyTime;
    }

    public void setValueOfRecentlyTime(String valueOfRecentlyTime) {
        this.valueOfRecentlyTime = valueOfRecentlyTime;
    }

    public static class Builder {

        private String alias;
        private String versionName;
        private String buildType;
        private String firstTime;
        private String recentlyTime;

        private Builder() {
        }

        public Builder(String alias) {
            this.alias = alias;
        }

        private String getAlias() {
            return alias;
        }

        public String getVersionName() {
            return versionName;
        }

        public Builder setVersionName(String versionName) {
            this.versionName = versionName;
            return this;
        }

        public String getBuildType() {
            return buildType;
        }

        public Builder setBuildType(String buildType) {
            this.buildType = buildType;
            return this;
        }

        public String getFirstTime() {
            return firstTime;
        }

        public Builder setFirstTime(String firstTime) {
            this.firstTime = firstTime;
            return this;
        }

        public String getRecentlyTime() {
            return recentlyTime;
        }

        public Builder setRecentlyTime(String recentlyTime) {
            this.recentlyTime = recentlyTime;
            return this;
        }

        private final String combine(String value) {
            if (null != value && !"".equals(value)) {
                return String.format("%s_%s", getAlias(), value);
            }
            return "";
        }

        public final Attribute create() {
            Attribute attribute = new Attribute();
            attribute.setKeyOfVersionName(combine(Config.VERSION_NAME.getValue()));
            attribute.setValueOfVersionName(getVersionName());
            attribute.setKeyOfBuildType(combine(Config.BUILD_TYPE.getValue()));
            attribute.setValueOfBuildType(getBuildType());
            attribute.setKeyOfFirstTime(combine(Config.FIRST_TIME.getValue()));
            attribute.setValueOfFirstTime(getFirstTime());
            attribute.setKeyOfRecentlyTime(combine(Config.RECENTLY_TIME.getValue()));
            attribute.setValueOfRecentlyTime(getRecentlyTime());
            return attribute;
        }
    }
}

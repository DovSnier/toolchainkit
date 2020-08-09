package com.dvsnier.permission;

/**
 * Permission
 * Created by dovsnier on 2020/7/28.
 */
public class Permission {

    protected String name;
    protected boolean granted;
    protected boolean shouldShowRequestPermissionRationale;

    public Permission() {
    }

    public Permission(String name, boolean granted, boolean shouldShowRequestPermissionRationale) {
        this.name = name;
        this.granted = granted;
        this.shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGranted() {
        return granted;
    }

    public void setGranted(boolean granted) {
        this.granted = granted;
    }

    public boolean isNegatived() {
        return !granted;
    }

    public boolean isShouldShowRequestPermissionRationale() {
        return shouldShowRequestPermissionRationale;
    }

    public void setShouldShowRequestPermissionRationale(boolean shouldShowRequestPermissionRationale) {
        this.shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale;
    }

    public boolean isNegativedAndNoPresentation() {
        return !granted && !shouldShowRequestPermissionRationale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (granted != that.granted) return false;
        if (shouldShowRequestPermissionRationale != that.shouldShowRequestPermissionRationale)
            return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (granted ? 1 : 0);
        result = 31 * result + (shouldShowRequestPermissionRationale ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", granted=" + granted +
                ", shouldShowRequestPermissionRationale=" + shouldShowRequestPermissionRationale +
                '}';
    }
}

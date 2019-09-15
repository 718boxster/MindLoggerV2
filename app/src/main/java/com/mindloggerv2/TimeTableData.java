package com.mindloggerv2;

public class TimeTableData {
    String startsAt;
    String endsAt;
    boolean isSelected = false;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public TimeTableData() {
    }

    public TimeTableData(String startsAt, String endsAt) {
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.isSelected = false;
    }
}

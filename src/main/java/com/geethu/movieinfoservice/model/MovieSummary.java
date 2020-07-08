package com.geethu.movieinfoservice.model;

public class MovieSummary {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    private String title;
    private String overView;
}

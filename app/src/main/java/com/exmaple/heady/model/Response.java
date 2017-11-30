package com.exmaple.heady.model;

import java.util.List;

public class Response {

    private List<Categories> categories;
    private List<Rankings> rankings;

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Rankings> getRankings() {
        return rankings;
    }

    public void setRankings(List<Rankings> rankings) {
        this.rankings = rankings;
    }
}

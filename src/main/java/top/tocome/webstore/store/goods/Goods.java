package top.tocome.webstore.store.goods;

import top.tocome.io.Http;

public abstract class Goods {

    protected String url;
    protected String actionStart;
    protected String descStart;
    protected String descEnd;

    protected String page;
    protected String actionData;
    protected String descUrl;
    protected String descData;

    public Goods(String url, String actionStart, String descStart, String descEnd) {
        this.actionStart = actionStart;
        this.descStart = descStart;
        this.descEnd = descEnd;
        this.url = url;
        this.page = Http.get(url);
    }

    protected void getActionData() {
        int start = page.indexOf(actionStart);
        int end = page.indexOf("]", start);
        actionData = page.substring(start, end);
    }

    protected void getDescData() {
        int start = page.indexOf("//", page.indexOf(descStart));
        int end = page.indexOf(descEnd, start);
        descUrl = "http:" + page.substring(start, end);
        descData = Http.get(descUrl);
    }

}

package top.tocome.webstore.store.goods;

import top.tocome.io.Http;
import top.tocome.webstore.utils.Img;

import java.util.ArrayList;

/**
 * 单个网络商品
 */
public abstract class Goods {
    /**
     * 商品链接
     */
    protected String url;
    /**
     * 展示图开始标签
     */
    protected String actionStart;
    /**
     * 展示图结束标签
     */
    protected String actionEnd;
    /**
     * 详情图开始标签
     */
    protected String descStart;
    /**
     * 详情图结束标签
     */
    protected String descEnd;
    /**
     * 商品网页内容
     */
    protected String page;
    /**
     * 展示图数据
     */
    protected String actionData;
    /**
     * 详情图数据链接
     */
    protected String descUrl;
    /**
     * 详情图数据
     */
    protected String descData;
    /**
     * 所有展示图的链接
     */
    protected ArrayList<String> actionImages;
    /**
     * 所有详情图的链接
     */
    protected ArrayList<String> descImages;

    public Goods(String url, String actionStart, String actionEnd, String descStart, String descEnd) {
        this.actionStart = actionStart;
        this.actionEnd = actionEnd;
        this.descStart = descStart;
        this.descEnd = descEnd;
        this.url = url;
    }

    public String getPage() {
        if (page == null) {
            page = Http.get(url);
        }
        return page;
    }

    public String getActionData() {
        if (actionData == null) {
            String page = getPage();
            int start = page.indexOf(actionStart);
            int end = page.indexOf(actionEnd, start);
            actionData = page.substring(start, end);
        }
        return actionData;
    }

    public String getDescUrl() {
        if (descUrl == null) {
            String page = getPage();
            int start = page.indexOf("//", page.indexOf(descStart));
            int end = page.indexOf(descEnd, start);
            descUrl = "http:" + page.substring(start, end);
        }
        return descUrl;
    }

    public String getDescData() {
        if (descData == null) {
            descData = Http.get(getDescUrl());
        }
        return descData;
    }

    public ArrayList<String> getActionImages() {
        if (actionImages == null) {
            actionImages = Img.toImgArray(getActionData());
        }
        return actionImages;
    }

    public ArrayList<String> getDescImages() {
        if (descImages == null) {
            descImages = Img.toImgArray(getDescData());
        }
        return descImages;
    }
}

package com.renata.mentesaudvel.Model;

public class ReadItem {
    public String readitem_id;
    public String readitem_title;
    public String readitem_detail;

    public ReadItem() {

    }

    public ReadItem(String readitem_id, String readitem_title,String readitem_detail) {
        this.readitem_id = readitem_id;
        this.readitem_title = readitem_title;
        this.readitem_detail = readitem_detail;

    }
    public String getreaditem_id() {
        return  readitem_id;
    }
    public void setreaditem_id(String readitem_id) {
        this.readitem_id = readitem_id;
    }
    public String getreaditem_title() {
        return readitem_title;
    }

    public void setreaditem_title(String readitem_title) {
        this.readitem_title = readitem_title;
    }

    public String getreaditem_detail() {
        return readitem_detail;
    }

    public void setreaditem_detail(String readitem_detail) {
        this.readitem_detail = readitem_detail;
    }


}
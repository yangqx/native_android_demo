package com.example.helloworld2.okhttp.bean;

import org.w3c.dom.Entity;

import java.util.ArrayList;

public class FirstPageBean {
    private Integer status;
    private String error;
    private ArrayList<Entity> entity;

    @Override
    public String toString() {
        return "FirstPageBean{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", entity=" + entity +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Entity> getEntity() {
        return entity;
    }

    public void setEntity(ArrayList<Entity> entity) {
        this.entity = entity;
    }

    private class Entity{
        private Integer id;
        private String title;
        private Integer showOrder;
        private String imgUrl;
        private String status;

        @Override
        public String toString() {
            return "Entity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", showOrder=" + showOrder +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getShowOrder() {
            return showOrder;
        }

        public void setShowOrder(Integer showOrder) {
            this.showOrder = showOrder;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}

package com.springbook.biz.collectionList;

import java.util.List;

public class CollectionBean {
    private List<String> addressList;
    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public List<String> getAddressList() {
        return this.addressList;
    }
}

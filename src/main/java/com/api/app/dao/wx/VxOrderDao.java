package com.api.app.dao.wx;


public interface VxOrderDao {

    Boolean update(String outTradeNo,String totalFee);
    Boolean delete(String outTradeNo);
}

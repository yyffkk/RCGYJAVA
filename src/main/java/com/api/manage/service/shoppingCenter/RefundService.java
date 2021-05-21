package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.RefundSearch;
import com.api.vo.shoppingCenter.RefundVo;

import java.util.List;

public interface RefundService {
    List<RefundVo> list(RefundSearch refundSearch);
}

package com.api.app.service.butler;

import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.app.AppMyArticleBorrowVo;

import java.util.List;
import java.util.Map;

public interface AppArticleBorrowService {
    List<AppArticleBorrowVo> list();

    List<AppMyArticleBorrowVo> myList(Integer id);

    Map<String, Object> frmLoss(UserIdAndArticleBorrowId userIdAndArticleBorrowId);

    Map<String, Object> findDetailById(Integer articleId);
}

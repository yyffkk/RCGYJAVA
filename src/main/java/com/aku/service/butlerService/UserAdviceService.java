package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserAdvice;
import com.aku.vo.butlerService.VoUserAdvice;

import java.util.List;

public interface UserAdviceService {
    List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice);
}

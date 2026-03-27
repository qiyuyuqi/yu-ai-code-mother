package com.yuqi.yuaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yuqi.yuaicodemother.model.entity.App;
import com.yuqi.yuaicodemother.model.entity.User;
import com.yuqi.yuaicodemother.model.dto.app.*;
import com.yuqi.yuaicodemother.model.vo.*;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/liyupi">wuyq</a>
 */
public interface AppService extends IService<App> {

    AppVO getAppVO(App app);

    Long createApp(AppAddRequest appAddRequest, User loginUser);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);


    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);

    public List<AppVO> getAppVOList(List<App> appList);

    void generateAppScreenshotAsync(Long appId, String appUrl);
}

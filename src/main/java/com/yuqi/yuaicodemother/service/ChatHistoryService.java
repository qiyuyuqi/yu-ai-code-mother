package com.yuqi.yuaicodemother.service;


import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.yuqi.yuaicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.yuqi.yuaicodemother.model.entity.ChatHistory;
import com.yuqi.yuaicodemother.model.entity.User;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author <a href="https://github.com/yuqiqiyu">wuyq</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    public boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    public boolean deleteByAppId(Long appId);

    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);


    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);
}

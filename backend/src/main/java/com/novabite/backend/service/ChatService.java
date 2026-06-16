package com.novabite.backend.service;

import com.novabite.backend.domain.dto.request.ChatRequest;
import com.novabite.backend.domain.dto.response.ChatResponse;

public interface ChatService {
    ChatResponse chat(ChatRequest request);
}

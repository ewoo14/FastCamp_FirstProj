package com.sparta.project.controller;

import com.sparta.project.dto.ai.AIChatRequest;
import com.sparta.project.dto.ai.AIChatResponse;
import com.sparta.project.dto.ai.AIDescRequest;
import com.sparta.project.dto.ai.AIDescResponse;
import com.sparta.project.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class AIController {

    private AIService aiService;

    // 챗봇 질문에 대한 답변 요청
    @PostMapping("/chat")
    public AIChatResponse postChat(@RequestBody AIChatRequest aiChatRequest) {
        return aiService.processChat(aiChatRequest);
    }

    // 음식 설명 생성
    @PostMapping("/desc")
    public AIDescResponse postDescription(@RequestBody AIDescRequest aiDescRequest) {
        return aiService.generateDescription(aiDescRequest);
    }
}
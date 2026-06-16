package com.novabite.backend.controller;

import com.novabite.backend.domain.dto.request.ChatRequest;
import com.novabite.backend.domain.dto.response.ChatResponse;
import com.novabite.backend.domain.dto.response.ProductResponse;
import com.novabite.backend.domain.dto.response.SummaryResponse;
import com.novabite.backend.domain.dto.response.TrendResponse;
import com.novabite.backend.service.ChatService;
import com.novabite.backend.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SalesController {
    private final SaleService saleService;
    private final ChatService chatService;

    @GetMapping("/summary")
    public SummaryResponse getSummary() {
        return saleService.getSummary();
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return saleService.getProducts();
    }

    @GetMapping("/trends")
    public List<TrendResponse> getMonthlyTrends() {
        return saleService.getMonthlyTrends();
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }
}

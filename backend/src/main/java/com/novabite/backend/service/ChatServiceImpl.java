package com.novabite.backend.service;

import com.novabite.backend.domain.dto.request.ChatRequest;
import com.novabite.backend.domain.dto.response.ChatResponse;
import com.novabite.backend.domain.entity.Sale;
import com.novabite.backend.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final GeminiService geminiService;
    private final SaleRepository saleRepository;

    @Override
    public ChatResponse chat(ChatRequest request) {

        List<Sale> sales = saleRepository.findAll();

        StringBuilder prompt = new StringBuilder();

        prompt.append("""
            You are a business intelligence assistant for NovaBite Consumer Goods.

            Answer ONLY using the provided sales data.

            If the answer cannot be determined from the data,
            explicitly say so.

            Sales Data:

            """);

        for (Sale sale : sales) {

            prompt.append(String.format(
                    "%s,%s,%s,%s,%s,%d,%s%n",
                    sale.getDate(),
                    sale.getQuarter(),
                    sale.getRegion(),
                    sale.getProductName(),
                    sale.getChannel(),
                    sale.getUnitsSold(),
                    sale.getNetRevenueUsd()
            ));
        }

        prompt.append("\nQuestion:\n");
        prompt.append(request.question());

        String answer = geminiService.generate(prompt.toString());

        return new ChatResponse(answer);
    }
}
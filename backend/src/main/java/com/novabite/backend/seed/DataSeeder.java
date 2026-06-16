package com.novabite.backend.seed;

import com.novabite.backend.domain.entity.Sale;
import com.novabite.backend.repository.SaleRepository;
import com.opencsv.CSVReaderHeaderAware;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final SaleRepository saleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (saleRepository.count() > 0) {
            return;
        }

        ClassPathResource classPathResource = new ClassPathResource("novabite_sales_data.csv");

        try (
                InputStreamReader reader = new InputStreamReader(classPathResource.getInputStream());
                CSVReaderHeaderAware csv = new CSVReaderHeaderAware(reader);
                ) {
            Map<String, String> row;

            while ((row = csv.readMap()) != null) {
                Sale sale = Sale.builder()
                        .transactionId(row.get("transaction_id"))
                        .date(LocalDate.parse(row.get("date")))
                        .month(row.get("month"))
                        .quarter(row.get("quarter"))
                        .sku(row.get("sku"))
                        .productName(row.get("product_name"))
                        .category(row.get("category"))
                        .subcategory(row.get("subcategory"))
                        .region(row.get("region"))
                        .channel(row.get("channel"))
                        .salesRep(row.get("sales_rep"))
                        .unitsSold(Integer.parseInt(row.get("units_sold")))
                        .unitPriceUsd(Double.parseDouble(row.get("unit_price_usd")))
                        .grossRevenueUsd(Double.parseDouble(row.get("gross_revenue_usd")))
                        .discountPct(Double.parseDouble(row.get("discount_pct")))
                        .netRevenueUsd(Double.parseDouble(row.get("net_revenue_usd")))
                        .cogsUsd(Double.parseDouble(row.get("cogs_usd")))
                        .grossProfitUsd(Double.parseDouble(row.get("gross_profit_usd")))
                        .build();

                saleRepository.save(sale);
            }
        }
    }
}

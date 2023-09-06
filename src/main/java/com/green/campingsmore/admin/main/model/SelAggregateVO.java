package com.green.campingsmore.admin.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelAggregateVO {
    private String date;
    private Integer orderTotalPrice;
    private Long orderTotalCount;
    private Integer shippingCompleteTotalPrice;
    private Long shippingCompleteTotalCount;
    private Integer refundTotalPrice;
    private Long refundTotalCount;
}
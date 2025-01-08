package com.ecom.shopease.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
@EnableBatchProcessing
public class BatchConfig {
//    private TransactionManager transactionManager;
//
//    @Bean
//    public Step step(StepBuilder stepBuilder, ItemReader<String> reader,
//                     ItemProcessor<String,String> processor,
//                     ItemWriter<String> writer){
//        return stepBuilder.<String,String>chunk(10)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//
//    }
}

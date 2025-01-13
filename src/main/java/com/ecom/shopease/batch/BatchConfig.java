package com.ecom.shopease.batch;

import com.ecom.shopease.entities.Category;
import com.ecom.shopease.repositories.CategoryRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    private CategoryRepository categoryRepository;


//    @Bean
//    public Job job(JobRepository jobRepository, Step step) {
//        return new JobBuilder("job", jobRepository)
//                .start(step)
//                .build();
//    }
//

//    @Bean
//    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("step", jobRepository)
//                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
//                    System.out.println("hello, friends!");
//                    return RepeatStatus.FINISHED;
//                }, transactionManager).build();
//    }



    @Bean
    public FlatFileItemReader<Category> reader() {
        FlatFileItemReader<Category> itemReader = new FlatFileItemReader();
        itemReader.setResource(new FileSystemResource("src/main/resources/categories.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Category> lineMapper() {
        DefaultLineMapper<Category> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "createdAt", "updatedAt");

        BeanWrapperFieldSetMapper<Category> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Category.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public ItemProcessor<Category, Category> processor() {
        return new CategoryProcessor();
    }

    @Bean
    public ItemWriter<Category> writer(){
        RepositoryItemWriter<Category> writer = new RepositoryItemWriter<>();
        writer.setRepository(categoryRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager) {
        return new StepBuilder("csvReader",jobRepository)
                .<Category, Category>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, Step step){
        return new JobBuilder("categoryJob",jobRepository)
                .start(step)
                .build();
    }
}
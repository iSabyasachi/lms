package com.lms.batchlibrarymongo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.lms.batchlibrarymongo.domain.User;
import com.lms.batchlibrarymongo.model.UserDetail;

@Configuration
public class BatchUserConfig {
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
					StepBuilderFactory stepBuilderFactory,
					ItemReader<UserDetail> itemReader,
					ItemProcessor<UserDetail, User> itemProcessor,
					ItemWriter<User> itemWriter) {
		
		Step step = stepBuilderFactory.get("Library-ETL-File-Load")
					.<UserDetail, User>chunk(100)
					.reader(itemReader)
					.processor(itemProcessor)
					.writer(itemWriter)
					.build();
		
		return jobBuilderFactory.get("Library-ETL-Load")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<UserDetail> itemReader(){
		FlatFileItemReader<UserDetail> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/user-sample-data.csv"));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<UserDetail> lineMapper() {
		DefaultLineMapper<UserDetail> defaultLineMapper = new DefaultLineMapper<UserDetail>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"email", "firstName", "lastName", "mobileNumber"});
		
		
		BeanWrapperFieldSetMapper<UserDetail> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<UserDetail>();
		beanWrapperFieldSetMapper.setTargetType(UserDetail.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		return defaultLineMapper;
	}
	
	@Bean
    public MongoItemWriter<User> itemWriter(MongoTemplate mongoTemplate){
    	MongoItemWriterBuilder<User> dbWriter = new MongoItemWriterBuilder<>();
    	dbWriter.template(mongoTemplate).collection("user");
    	return dbWriter.build();
    }
	
}

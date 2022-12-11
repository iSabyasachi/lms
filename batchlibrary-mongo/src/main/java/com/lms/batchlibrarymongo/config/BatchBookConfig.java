package com.lms.batchlibrarymongo.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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

import com.lms.batchlibrarymongo.domain.Book;
import com.lms.batchlibrarymongo.model.BookDetail;
import com.lms.batchlibrarymongo.processor.BookItemProcessor;

@Configuration
public class BatchBookConfig {
	@Bean
	public Job bookJob(JobBuilderFactory jobBuilderFactory,
					StepBuilderFactory stepBuilderFactory,
					ItemReader<BookDetail> bookReader,
					ItemProcessor<BookDetail, Book> bookProcessor,
					ItemWriter<Book> bookWriter) {
		
		Step step = stepBuilderFactory.get("Library-ETL-Book-Load")
					.<BookDetail, Book>chunk(100)
					.reader(bookReader)
					.processor(bookProcessor)
					.writer(bookWriter)
					.build();
		
		return jobBuilderFactory.get("Library-ETL-Book-Load")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	@Bean
	public ItemProcessor<BookDetail, Book> bookProcessor(){
		return new BookItemProcessor();
	}
	@Bean
	public FlatFileItemReader<BookDetail> bookReader(){
		FlatFileItemReader<BookDetail> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/book-sample-data.csv"));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(bookLineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<BookDetail> bookLineMapper() {
		DefaultLineMapper<BookDetail> defaultLineMapper = new DefaultLineMapper<BookDetail>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"id", "isbn", "barcode", "title", "type", "subject", "publisher", "publicationdate", "booklanguage", "numberofpages", "author", "description", "genre", "isreferenceonly", "active", "unit", "racknum", "status"});
		
		
		BeanWrapperFieldSetMapper<BookDetail> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<BookDetail>();
		beanWrapperFieldSetMapper.setTargetType(BookDetail.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		return defaultLineMapper;
	}
	
	@Bean
    public MongoItemWriter<Book> bookWriter(MongoTemplate mongoTemplate){
    	MongoItemWriterBuilder<Book> dbWriter = new MongoItemWriterBuilder<>();
    	dbWriter.template(mongoTemplate).collection("book");
    	return dbWriter.build();
    }
	
}

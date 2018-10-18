package io.github.coffeeshop.catalogue;

import com.github.mongobee.Mongobee;
import io.github.coffeeshop.catalogue.repository.ProductRepository;
import io.github.coffeeshop.catalogue.repository.migration.Migration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class CatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

	@Bean
	public Mongobee mongobee(MongoProperties properties) {
		Mongobee runner = new Mongobee(properties.getUri());
		runner.setChangeLogsScanPackage(Migration.class.getPackage().getName());
		return runner;
	}
}

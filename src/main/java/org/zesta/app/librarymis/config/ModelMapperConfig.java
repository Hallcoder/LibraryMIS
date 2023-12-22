package org.zesta.app.librarymis.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zesta.app.librarymis.models.Book;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Example: Custom mapping configuration
        // modelMapper.addMappings(new BookMap());
        modelMapper.addMappings(new PropertyMap<Book, Book>() {
            @Override
            protected void configure() {
                skip(destination.getId()); // Exclude mapping for the 'id' field
            }
        });

        return modelMapper;
    }
}

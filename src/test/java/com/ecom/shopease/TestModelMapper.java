package com.ecom.shopease;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestModelMapper {

    ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {

         modelMapper = new ModelMapper();
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        Converter<String,LocalDate> converter = ctx -> {
            return ctx.getSource() != null ? LocalDate.parse(ctx.getSource(),simpleDateFormat) : null ;
        };
         modelMapper.typeMap(Game.class, GameDto.class).addMappings(
                 mapping -> mapping.using(converter).map(Game::getDate,GameDto::setDate)
         );
    }

    @Test
    void test() {
        Game game = new Game();
        game.setName("Game 1");
        game.setDate("2025-05-04T14:30:00-05:00");

        GameDto gameDto = modelMapper.map(game, GameDto.class);
        System.out.println(gameDto);

    }

}

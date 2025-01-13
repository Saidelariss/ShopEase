package com.ecom.shopease;

import com.ecom.shopease.dtos.CategoryResponse;
import com.ecom.shopease.entities.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShopEaseApplicationTests {
    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    void setup() {

    }

    @Test
    public void tesModelMapperMapping() {
        Category category = new Category(1, "c", LocalDateTime.now(), LocalDateTime.now(), List.of());
        CategoryResponse response = new CategoryResponse();
        TypeMap<Category, CategoryResponse> typeMap = modelMapper.createTypeMap(Category.class, CategoryResponse.class);
        typeMap.addMapping(Category::getId, CategoryResponse::setName);
        response = modelMapper.map(category, CategoryResponse.class);
        Assertions.assertEquals(category.getId().toString(), response.getName());
        Assertions.assertEquals(category.getId(), response.getId());
    }

    @Test
    public void testModelMapperLooseStrategy() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<Game, GameDto> typeMap = modelMapper.createTypeMap(Game.class, GameDto.class);
        typeMap.addMappings(mapper -> {
            mapper.map(game -> game.getSettingGame() == null ? new ArrayList<>() : game.getSettingGame().stream().map(SettingGame::getMode).toList(), GameDto::setModes);
        });
        SettingGame settingGame1 = new SettingGame(6, "mode1");
        SettingGame settingGame2 = new SettingGame(34, "mode2");
        List<SettingGame> settingGames = List.of(settingGame1, settingGame2);
        Game game = new Game(settingGames, "chess");
        GameDto gameDto = modelMapper.map(game, GameDto.class);

        List<String> list = game.getSettingGame().stream().map(SettingGame::getMode).toList();
        Assertions.assertIterableEquals(list, gameDto.getModes());
        Assertions.assertEquals(gameDto.getName(), game.getGameName());


    }

}

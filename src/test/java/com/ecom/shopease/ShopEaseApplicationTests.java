package com.ecom.shopease;

import com.ecom.shopease.dtos.CategoryResponse;
import com.ecom.shopease.entities.Category;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ShopEaseApplicationTests {
	@Autowired
	ModelMapper modelMapper;
	@BeforeEach
	void setup(){

	}

	@Test
	public void tesModelMapperMapping(){
		Category category = new Category(1,"c", LocalDateTime.now(),LocalDateTime.now(), List.of());
		CategoryResponse response = new CategoryResponse();
		TypeMap<Category, CategoryResponse> typeMap = modelMapper.createTypeMap(Category.class, CategoryResponse.class);
		typeMap.addMapping(Category::getId,CategoryResponse::setName);
		response = modelMapper.map(category,CategoryResponse.class);
		Assertions.assertEquals(category.getId().toString(),response.getName());
		Assertions.assertEquals(category.getId(),response.getId());
	}

	@Test
	public void testModelMapperLooseStrategy(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		SettingGame settingGame= new SettingGame(6,"mode1");
		Game game = new Game(settingGame,"chess");
		GameDto gameDto = modelMapper.map(game, GameDto.class);

		Assertions.assertEquals(gameDto.getMaxPlayers(),game.getSettingGame().getMaxPlayers());
		Assertions.assertEquals(gameDto.getName(),game.getGameName());
		Assertions.assertEquals(gameDto.getMode(),game.getSettingGame().getMode());
	}

}

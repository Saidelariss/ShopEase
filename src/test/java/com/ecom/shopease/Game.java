package com.ecom.shopease;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Game {
    private List<SettingGame> settingGame = new ArrayList<>();
    private String gameName;

}

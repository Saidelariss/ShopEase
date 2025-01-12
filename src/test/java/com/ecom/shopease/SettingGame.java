package com.ecom.shopease;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SettingGame {
    private int maxPlayers;
    private String mode;
}

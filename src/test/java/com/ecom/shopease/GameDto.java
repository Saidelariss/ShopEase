package com.ecom.shopease;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameDto {
    private int maxPlayers;
    private String mode;
    private String name;

}

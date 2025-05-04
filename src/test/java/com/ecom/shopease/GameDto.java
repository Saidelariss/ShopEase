package com.ecom.shopease;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
public class GameDto {
    private String name;
    private LocalDate date;
}

package com.example.tilultimatemain.global.properties;

import com.example.tilultimatemain.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {JwtProperties.class})
public class EnableConfigurationPropertiesConfig {
}

package com.swontech.s02.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "db.datasource")
public class DBProperty {
    // primary datasource properties
    @NotEmpty
    private String primaryUrl;
    @NotEmpty
    private String primaryUserName;
    @NotEmpty
    private String primaryPassword;
    @NotEmpty
    private String primaryDriver;
}

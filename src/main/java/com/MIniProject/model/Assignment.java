package com.MIniProject.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("assignment")
public class Assignment {

    @Id
    @NotBlank(message = "{id.not-null}")
    @Size(min = 6, max = 8, message = "{id.size}")
    @Pattern(regexp = "^[a-zA-Z0-9]+", message = "{id.pattern}")
    private String id;
    @NotBlank(message = "{asgTitle.not-null}")
    private String asgTitle;
    @NotBlank(message = "{instrName.not-null}")
    private String instrName;
    @NotBlank(message = "{stdName.not-null}")
    private String stdName;
    @NotBlank(message = "{status.not-null}")
    private String status;


}

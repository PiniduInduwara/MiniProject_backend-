package com.MIniProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("assignment")
public class Assignment {

    @Id
    private String id;
    private String asgTitle;
    private String instrName;
    private String stdName;
    private String status;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date deadline;
//    @CreatedDate
//    private Date asgUploadedAt;
//    @LastModifiedDate
//    private Date lastUpdatedAt;


}

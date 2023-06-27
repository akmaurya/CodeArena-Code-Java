package com.c1India.loginVerification.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Todo {

	private int id;
    private String user;
    private String desc;
    private Date targetDate;
    private boolean isDone;
}

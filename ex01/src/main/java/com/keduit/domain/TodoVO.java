package com.keduit.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TodoVO {
	private long no;
	private String todoDate;
	private String content;
	private Date regDate;
	private Date updateDate;
}

package com.keduit.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private Criteria cri;
	private int firstPage;
	private int lastPage;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/ 5.0))*5;
		this.startPage = this.endPage - 4;
		int realPage = (int)(Math.ceil((total * 1.0)/cri.getAmount()));
		
		lastPage = realPage;
		firstPage = 1;
		
		if(realPage < this.endPage) {
			this.endPage = realPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realPage;
	}
}

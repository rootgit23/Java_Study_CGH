package com.im.start.board.qna;

import com.im.start.board.impl.BoardDTO;

public class QnaDTO extends BoardDTO {
	
	private Long ref;
	private Long step;
	private Long depth;
	private Long c;
	
	public Long getC() {
		return c;
	}
	public void setC(Long c) {
		this.c = c;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
	
}

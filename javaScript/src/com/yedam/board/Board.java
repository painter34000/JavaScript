package com.yedam.board;

public class Board {

	int boardNumber;
	String content, writer, createDate;

	
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Board [boardNumber=" + boardNumber + ", content=" + content + ", writer=" + writer + ", createDate="
				+ createDate + "]";
	}
	
	
	
}

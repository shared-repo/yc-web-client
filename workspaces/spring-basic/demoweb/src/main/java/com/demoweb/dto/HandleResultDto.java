package com.demoweb.dto;

// controller에서 처리한 결과를 frontcontroller로 반환할 때 사용할 데이터 저장 객체
public class HandleResultDto {
	
	private boolean redirect;
	private String viewName;
	private Object data;
	
	public HandleResultDto() {}
	public HandleResultDto(boolean redirect, String viewName, Object data) {
		this.redirect = redirect;
		this.viewName = viewName;
		this.data = data;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}

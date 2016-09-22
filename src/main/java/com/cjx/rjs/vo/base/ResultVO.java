package com.cjx.rjs.vo.base;

import java.io.Serializable;

import com.cjx.rjs.constant.Constant;

/**
 * @author caijx
 */
@SuppressWarnings("serial")
public class ResultVO<T> implements Serializable {

	/**
	 * true: 成功  false: 失败
	 */
	private boolean isSuccess;

	/**
	 * 返回编码
	 */
	private String resultCode;

	/**
	 * 返回信息
	 */
	private String resultMessage;

	/**
	 * 返回结果
	 */
	private T value;

	public static <T> ResultVO<T> newInstance() {
		ResultVO<T> resultVO = new ResultVO<T>();
		resultVO.setSuccess(true);
		return resultVO;
	}
	
	public static <T> ResultVO<T> newFailInstance() {
		ResultVO<T> resultVO = new ResultVO<T>();
		resultVO.setSuccess(false);
		return resultVO;
	}
	
	public static <T> ResultVO<T> newFailInstance(String resultCode, String resultMessage) {
		ResultVO<T> resultVO = new ResultVO<T>();
		resultVO.setSuccess(false);
		resultVO.setResultCode(resultCode);
		resultVO.setResultMessage(resultMessage);
		return resultVO;
	}
	
	public static <T> ResultVO<T> newFailInstance(String resultCode, Exception e) {
		e.printStackTrace();
		return newFailInstance(resultCode, e.getMessage());
	}
	
	public static <T> ResultVO<T> newFailInstance(Exception e) {
		return newFailInstance(Constant.RESULT_FAIL, e);
	}
	
	public static <T> ResultVO<T> newInstance(T object) {
		ResultVO<T> resultVO = new ResultVO<T>();
		if (object != null) {
			resultVO.setValue(object);
			resultVO.setSuccess(true);
		}
		return resultVO;
	}
	
	/**
	 * true: 成功  false: 失败
	 * @return
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

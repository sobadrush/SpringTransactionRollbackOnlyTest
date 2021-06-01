package com.roger.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptUtil {
	
	protected static final Base64.Decoder decoder = Base64.getDecoder();
	protected static final Base64.Encoder encoder = Base64.getEncoder();
	
	/**
	 * Base64編碼
	 * @param inputText : Base64前的字串
	 */
	public static String encodeStr(String inputText) {
		byte[] textByte = null;
		try {
			textByte = inputText.getBytes(StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encoder.encodeToString(textByte);
	}
	
	/**
	 * Base64編碼
	 * @param inputText : Base64後的字串
	 */
	public static String decodeStr(String encodedText) {
		try {
			return new String(decoder.decode(encodedText), StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return encodedText;
		}
	}
	
//	public static void main(String[] args) {
//		System.out.println(MyUtils.encodeStr("sa123456"));
//		System.out.println(MyUtils.decodeStr(MyUtils.encodeStr("sa123456")));
//	}
}

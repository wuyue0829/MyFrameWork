package com.iyy.myframework.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
	public static String getMD5(byte[] paramString)
			throws NoSuchAlgorithmException
			{
		for (;;)
		{
			StringBuilder localStringBuilder;
			int i;
			try
			{
				paramString = MessageDigest.getInstance("MD5").digest();
				localStringBuilder = new StringBuilder(paramString.length * 2);
				int j = paramString.length;
				i = 0;
				if (i >= j) {
					return localStringBuilder.toString();
				}
			}
			catch (NoSuchAlgorithmException paramString1)
			{
				return null;
			}
			int k = paramString[i];
			if ((k & 0xFF) < 16) {
				localStringBuilder.append("0");
			}
			localStringBuilder.append(Integer.toHexString(k & 0xFF));
			i += 1;
		}
			}
}


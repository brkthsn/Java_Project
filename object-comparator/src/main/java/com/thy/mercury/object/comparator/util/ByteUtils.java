package com.thy.mercury.inventory.parse.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ByteUtils

{
    private static final String CANNOT_COVERT_A_NULL_VALUE = "cannot covert a null value";
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static byte[] joinArrays(byte[]... arrays)
    {
        int totalLength = 0;
        for (int i = 0; i < arrays.length; i++)
        {
            totalLength += arrays[i].length;
        }
        byte[] joined = new byte[totalLength];
        int cursor = 0;
        for (int i = 0; i < arrays.length; i++)
        {
            for (int j = 0; j < arrays[i].length; j++)
            {
                joined[cursor++] = arrays[i][j];
            }
        }
        return joined;
    }

    public static int stringToInt(String integer)
    {
        return new BigInteger(integer.getBytes()).intValue();
    }

    public static byte[] hexStringtoByteArray(String hex)
    {
        if (hex == null)
        {
            throw new IllegalArgumentException(CANNOT_COVERT_A_NULL_VALUE);
        }
        String hexa = hex;
        if (hex.length() % 2 != 0)
        {
            hexa = "0" + hex;
        }
        byte[] array = new byte[hexa.length() / 2];
        for (int i = hexa.length(); i > 0; i -= 2)
        {
            int index = (i / 2) + (i % 2) - 1;
            array[index] = (byte) Integer.parseInt(hexa.substring(i - 2, i), 16);
        }
        return array;
    }

    public static byte[] intToCriIndexByteArray(int criIndex)
    {
        return intToByteArray(criIndex, 3);
    }

    public static byte[] intToByteArray(int integer, int length)
    {
        byte[] intArray = ByteBuffer.allocate(4).putInt(integer).array();
        byte[] resultArray = new byte[length];
        for (int i = 0; i < resultArray.length; i++)
        {
            resultArray[i] = intArray[i + 4 - length];
        }
        return resultArray;
    }

    public static void resetByteArray(byte[] array)
    {
        Arrays.fill(array, (byte) 0);
    }

    public static int byteArrayToInt(byte[] array)
    {
        return new BigInteger(array).intValue();
    }

    
    public static int byteArrayToIntUnsigned(byte[] array)
    {
    	BigInteger result= new BigInteger(array);
    	if (result.intValue() <0){
    		return result.intValue()&0xFF;
    	}
        return result.intValue();
    }

    
    public static void replaceBytes(byte[] array, byte[] replaceThese, byte[] withThese)
    {
        if (array == null || replaceThese == null || withThese == null)
        {
            return;
        }
        if (replaceThese.length != withThese.length)
        {
            return;
        }
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < replaceThese.length; j++)
            {
                if (array[i] == replaceThese[j])
                {
                    array[i] = withThese[j];
                }
            }
        }
    }

    public static String byteArrayToHexString(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++)
        {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    
    
    public static int byteArrayToInt2 (byte[] bytes) {
    	//bytes[0]=00;
    	//bytes[1]=98;
    	return (int) Long.parseLong(byteArrayToHexString(bytes),16);
    }

    public static String byteArrayToBinaryString(byte[] bytes)
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for (int i = 0; i < Byte.SIZE * bytes.length; i++)
        {
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        }
        return sb.toString();
    }
    
    public static String byteToUnsignedHex(int i) {
        String hex = Integer.toHexString(i);
        while(hex.length() < 8){
            hex = "0" + hex; 
        }
        return hex;
    }

    
    public static String intArrToHex(int[] arr) {
        StringBuilder builder = new StringBuilder(arr.length * 8);
        for (int b : arr) {
            builder.append(byteToUnsignedHex(b));
        }
        return builder.toString();
    }
    
    
    
    final protected static char[] encoding = "0123456789ABCDEF".toCharArray();
    public static String convertIntArrayToString(int[] arr) {
        char[] encodedChars = new char[arr.length * 4 * 2];
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            int idx = i * 4 * 2;
            for (int j = 0; j < 8; j++) {
                encodedChars[idx + j] = encoding[(v >>> ((7-j)*4)) & 0x0F];
            }
        }
        return new String(encodedChars);
    }

    
	public static String convertHexValueToDate(String hexValue) {
		LocalDate date = LocalDate.of(1966, 01, 02);
		date=date.plusDays(Integer.parseInt(hexValue,16));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateStr = date.format(formatter);
		return dateStr;	
	}
	
	

	
	public static int convertIntToHexValue(int n) {

		return Integer.valueOf(String.valueOf(n), 16);
		}

}

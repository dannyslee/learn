package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101800718214";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCakQQ07994j3zC0B0mNRV/Asm7onoMbzUgieRZSyRiMOcKQmYbBNxA8de75HChE+0qRBwADyO9MV8Y9w1Jg2UhZS55szuJo4nNLamgLa+GaX2vkM5Jt9u/cJX/wJNbWJkvJNrs702NxM74MGnaDTBSrY9O6bQvkO9nzX5VVxsVmjK0DNh0/RQ/xSbWfkM1Af+w50RRxcnNbb282IhZmoo9Ajq/8/d9DMUcUjUvr5Jcc3KTrDmxfd9ywU2QPS5OA/9tsglY0uvy8c2YM0rcTxa3tcHQnYFfqT1xaayu591GkWWFnCLu+jIw0rjzcppH3Pk5YTo2s65Z9WJHKPI4HO4XAgMBAAECggEAbbaX7NeDoXkATuwYdMFjY8df2H8o8OCTLmiSnMtYpRYfOUoOXgliKftAbc9mHwAc7U5xLZ2Reb6syPS8Cr1osH64sYwGq9lYfDp4WAl1uQvyOgeoVe1a3xWUc3iHYGSQP0WC3IG0Y/gaDVOYHz4TWex2d8Ytr0HKnbzgesUcpYSyiGO7rV7+42LE0zHp/aZdK/K2npsG8NfK/3VKCXVcK6aWzTfNuDyJ1HhX3HzCbuqqNRTltH8TTm2RwqWR+Qf1Xtczcjw4QsHdcAS/uQqZBl0kcSWq3CzGnuGiKYU3h28G2rWX2ys/r08H9Lpag2jwFASiiuFHjd4x+0Lp+MEzmQKBgQDuWNm/f+bCMOj7ZpIGW1oxo//sRZsY2W0R/iaccruQFp7Tf5mATUCpb4dTHb3s+rRduvLbEznOSL+e814idopXTbCv+cvmj/RSX9OpgTFE9o85LhPVIsUr7BQQ+mqc1YSGuBafEUuRXCaq/5IQcL9AhNqUi3+2D7ecH3Nr1EBSqwKBgQCmA6eFc3JBHgi3YcaUKk1Hh71YsIwQ6XGOsrDsNh6OjBfJsUCRdVr8RinqLsFAgBFvX9pS0T4Y5KmPOMR+6g9GCGpsm5SGlthu5jubtft8J09GQpWracr8fsovrYPEZFtkkwVVSITv9nDbHE6PpySR+XLfDtwxTp4fpmRDtePyRQKBgEaKPUeTzvPCDfH5lVYUS0lNxDxlDVX5Y3JjyYGb4y7twuvNY9y5AF4lB+PtdXxhZmgnICD+O6l1lmCwnjeM5byY3aX3RAVkrWaDvdz4w2ApqJG/tVbrB3fMUtQDiPIJr0M/0FIbiEXpA/iv0sbS14d8ykQUVSPI2wp1tG9BThgpAoGAPRBXDCU8v2r2tc1HJ7SvnEH3ianWu1nCpURhA2Gct74b+doy784E24pLXJI6DymMQDU3rwK8HpftLnso+63IVHBABRbs+Nx/W7tf7ZRwnmgvJp7TQqu1OE7Cu+rM7u4jF8lkSsxT6ZfyRwYQd5J5RyBD+nwSzigmzWl8s9MxtykCgYBpLzX0cSM1AITRLyLY+KhEf1IzGIVqDgvTJEQUjpANK6+S/KTj6CGcNN2v5BnApvjXcLVA2TO3Ic9gAyrC7Z+1w2LKukpA1RdQ2X18I5TbGNEHoeob6SF/0Z7hYpKJvwrtk7OCW9Z1wXCUwpL0iryJPSFzDhQZdN5Wjm0YLyQFPA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh0pyK6Z7Ma6aFKjMTjmimZSQcDGlBzpqqn9f5mleC+IrR3ve9sNcS3J5MNY50ld+OifgXGMGEqGXW+LvhpT+EOAcp84KMoJEBgx8QlL5SCZNLJg6+bhuyYQtYMV4RPkAyFGgr9m1+qu0OLguAvZIef1KGpNER6M7KBXp0GTAMCoqK+lEMNDDUd9jGZsYTCnTvUZHR8HfqakbD1+u7R5O1TGgZ46nWv5i7MFCwtgQwJTON0JB+jGVJ7pe66y+FcI53u5mFhYq4EDF8ZJlE0ZycnMU1aSFlduS8r1OTeRUhty7mH9OahN2RtAUhAiynncuEuJ0xvAZZ5YXCPiGIvMD6wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://123.56.124.113:10061/SpringMVCDemo/controller/pay/payNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://123.56.124.113:10061/SpringMVCDemo/controller/pay/payReturn";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\JAVA\\Paylog";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


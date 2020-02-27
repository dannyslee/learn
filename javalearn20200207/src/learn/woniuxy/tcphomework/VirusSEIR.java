package learn.woniuxy.tcphomework;

public class VirusSEIR {
	
	//收集数据
	StringBuffer sb = new StringBuffer();
	
	//模型预设:S - E - I - R
    float[] S = new float[1000]; //S
	float[] E = new float[1000];
	float[] I = new float[1000];
	float[] R = new float[1000];
		
	
	//传染率*平均接触人数
	float b = 1/2;
	
	//隔离速率，潜伏时间取倒数
	float a = 1/7;
	
	//总人数
	float N = 1400000000;
	
	//感染人恢复与死亡的平均速率，以感染平均时长14来取倒数
	float r=1/14;
			
	//时间
	int t;
	
	//实际模型
	void seir() {
		//初始隔离人数（确证人数）
		I[0] = 1;
		//初始易感人数
		S[0] = N-I[0];
		//初始潜伏人数
		E[0]=0;
		//计算
		for(t=0;t<999;t++) {
			S[t+1] = S[t]-b*I[t]*S[t]/N;
			E[t+1] = E[t]+b*I[t]*S[t+1]/N-a*E[t];
			I[t+1] = I[t]+a*E[t+1]-r*I[t];
			R[t+1] = r*I[t+1]+R[t];
		}
		
		for(float s:E) {
			
			System.out.println("E:"+s);
		}
		
	}
	
	public static void main(String[] args) {
		VirusSEIR m = new VirusSEIR();
		m.seir();	
	}
	
	
}

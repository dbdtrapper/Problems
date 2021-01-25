import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2138_전구와스위치 {
static int N;
static int min;
static char [][]before;
static char []after;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//before을 두가지 경우로 저장
		before = new char[2][N];
		after = new char[N];
		String line = br.readLine();
		before[0] = line.toCharArray();
		before[1] = line.toCharArray();
		//after 저장
		line = br.readLine();
		after = line.toCharArray();
		min = Integer.MAX_VALUE;
		//0번 스위치 안누르고 시작
		go(1,0,0);
		//0번 스위치 누르고 시작
		push(0,1);
		go(1,1,1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void go(int index, int count, int type) {
		// TODO Auto-generated method stub
		if(index==N) {
			//끝까지 왔으면
			if(before[type][index-1]==after[index-1]) {
				min=min>count?count:min;
				return;
			}
			if(before[type][index-1]!=after[index-1]) {
				//만약 같지 않으면
				//버튼 누르고
				push(index,type);
				//다음 인덱스로 이동
				go(index+1,count+1,type);
			}else {
				//같으면 버튼 안누르고 다음 인덱스로 이동
				go(index+1,count,type);
			}
		}
	}
	private static void push(int index, int type) {
		// TODO Auto-generated method stub
		for (int i = index-1; i <= index+1; i++) {
			if(i>=0&&i<N) {	//인덱스가 범위 안에 있으면
				before[type][i]=before[type][i]=='1'?'0':'1';
			}
		}
	}


}

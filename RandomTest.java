import java.util.Random;

class RandomTest{
	public static void main(String args[]){
		/*String s = "15";
		int n = Integer.parseInt(s);

		int newrand = rand.nextInt(n+1);
		System.out.println(newrand);
	
		int newnewrand = rand.nextInt((n-newrand)+1);
		System.out.println(newnewrand);

		System.out.println(n-(newrand+newnewrand));
*/
		Random rand = new Random();
		int qMcq[] = new int[5];
outer:		for(int i=0;i<5;){
				int temp = rand.nextInt(20+1);
				System.out.println("temp: "+temp);
				if(temp!=0){
					if(i==0){
						qMcq[i]=temp;
						System.out.println("qMcq i: "+i+" "+qMcq[i]);
						i++;
						continue;
					}
					for(int j=0;i!=0 & j<i;j++){
						if(qMcq[j]==temp){
							continue outer;
						}
						else if(j==i-1 && temp!=qMcq[j]){
							qMcq[i]=temp;
							System.out.println("qMcq i: "+i+" "+qMcq[i]);
							i++;
							continue outer;
						}
					}
				}
			}

	}
}
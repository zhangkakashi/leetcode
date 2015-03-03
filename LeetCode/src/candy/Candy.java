package candy;

public class Candy {

	public static int candy(int[] ratings) {
        if(ratings.length<1){
            return 0;
        }
        int[] val = new int[ratings.length];
        val[0] = 1;
        for(int i=1;i<ratings.length;i++){
        	//System.out.println(ratings[i]+"  "+ratings[i-1]+"  "+val[i-1]);
        	if(ratings[i]>ratings[i-1]){
                val[i] = val[i-1] + 1;
            }
                else if(ratings[i]<ratings[i-1]&&val[i-1]==1){
            	//System.out.println("hehe");
                val[i-1]++;
                val[i] = 1;
                int j=i-1;
                while(j>0&&val[j-1]==val[j]){
                	val[j-1]++;
                	j--;
                }
            }else{
                val[i] = 1;
            }
        }

        int res = val[0];
        System.out.println(res);
        for(int i=1;i<val.length;i++){
            res = res + val[i];
            System.out.println(val[i]);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		//int[] rate = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		int [] rate = {1,2,2,2,5,7,5,3,6};
		System.out.println(candy(rate));
	}

}

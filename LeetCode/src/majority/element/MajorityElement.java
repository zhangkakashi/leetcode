package majority.element;

public class MajorityElement {

	public int majorityElement(int[] num) {
        // Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        // for(int i=0;i<num.length;i++){
        //     if(!m.containsKey(num[i])){
        //         m.put(num[i],1);
        //     }else{
        //         if(m.get(num[i])+1>num.length/2){
        //             return num[i];
        //         }else{
        //             m.put(num[i],m.get(num[i])+1);
        //         }
        //     }
        // }
        // return num[0];
        
        int cur = 0;
        int count = 0;
        
        for(int i=0;i<num.length;i++){
            if(count == 0){
                count++;
                cur = num[i];
            }else if(num[i]==cur){
                count++;
                if(count>num.length/2){
                    return cur;
                }
            }else{
                count--;
            }
        }
        return cur;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

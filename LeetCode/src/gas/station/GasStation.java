package gas.station;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length!=cost.length){
            return -1;
        }
        if(gas.length==1){
            return gas[0]>=cost[0]?0:-1;
        }
        for(int i=0;i<gas.length;i++){
            int cur = gas[i];
            int c = cost[i];
            int remain = cur-c;
            if(remain<0){
                continue;
            }
            if(i==gas.length-1){
                for(int j=0;j<gas.length-1;j++){
                    remain = remain + gas[j]-cost[j];
                    if(remain>=0){
                        if(j==gas.length-2){
                            return i;
                        }
                    }else{
                        break;
                    }
                }
            }else{
                boolean ifCon = true;
                for(int j = i+1;j<gas.length;j++){
                    remain = remain + gas[j]-cost[j];
                    if(remain<0){
                        ifCon = false;
                        break;
                    }
                }
                if(ifCon){
                    for(int j=0;j<i;j++){
                        remain = remain + gas[j]-cost[j];
                        if(remain<0){
                        ifCon = false;
                        break;
                        }
                    }
                    if(ifCon){
                        return i;
                    }
                }
            }
            
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

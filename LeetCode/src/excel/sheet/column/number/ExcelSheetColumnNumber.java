package excel.sheet.column.number;

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
        int len = s.length();
        if(len<1){
            return 0;
        }
        int i = 0;
        int res = 0;
        while(i<len){
            res = res*26 + (s.charAt(i)-64);
            i++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

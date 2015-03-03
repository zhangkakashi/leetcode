package excel.sheet.column.title;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        String res = "";
        if(n<1){
            return res;
        }
        while(n>0){
            if(n%26==0){
                res = "Z" + res;
                n = n/26-1;
            }else{
                res = (char)(n%26+64)+res;
                n = n/26;
            }
        }
        
        return res;
    }
}

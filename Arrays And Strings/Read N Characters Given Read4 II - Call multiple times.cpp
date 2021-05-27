
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int tmpCnt = 0, tmpPtr = 0;
    char tmp[] = new char[4];
    public int read(char[] buf, int n) {
        int total = 0;
        while(total < n){
            if(tmpPtr == 0){
                tmpCnt = read4(tmp);
            }
            while(total < n && tmpPtr < tmpCnt){
                buf[total++] = tmp[tmpPtr++];
            }
            if(tmpPtr == tmpCnt) tmpPtr = 0;
            if(tmpCnt < 4) break;
        }
        return total;
    }
}
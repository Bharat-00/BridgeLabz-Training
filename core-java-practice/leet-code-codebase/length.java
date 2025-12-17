class LengthOfLastWord {
     public int lengthOfLastWord(String s) {
        s=s.trim();
        int count = 0;
        int len=s.length();
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==' '){
                break;
            }
            count++;
        }
        return count;
    }
}
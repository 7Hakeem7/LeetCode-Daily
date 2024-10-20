class Solution {
    public boolean solve(char a,char b,char o){
        boolean i=(a=='t');
        boolean j=(b=='t');
        if(o=='&') return i&&j;
        else return i||j;   
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stk=new Stack<>();
        Stack<Character> op=new Stack<>();
        
        for(char ch:expression.toCharArray()){
            if(ch==',') continue;
            if(ch=='&' || ch=='|' || ch=='!'){
                op.push(ch);
                continue;
            }
            if(ch=='(' || ch=='f' || ch=='t'){
                stk.push(ch);
                continue;
            }
            if(ch==')'){
                char operand=op.pop();
                char f=stk.pop();
                while(stk.peek()!='('){
                    boolean b=solve(f,stk.pop(),operand);
                    f=(b==true)?'t':'f';
                }
                stk.pop();
                if(operand=='!'){
                    stk.push((f=='t')?'f':'t');
                }else stk.push(f);
            }
           
        }
        return stk.pop()=='t';
    }
}
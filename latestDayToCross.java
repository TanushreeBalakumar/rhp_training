class Solution {
    private int gci(int row, int col,int C){
        return row*C+col+1;
    }
    private int find(int ldr[],int node){
        if(ldr[node]!=node){
            ldr[node]=find(ldr, ldr[node]);
        }
        return ldr[node];
    }
    private void join(int ldr[], int lt, int rt){
        ldr[find(ldr,rt)]=find(ldr,lt);
    }
    public int latestDayToCross(int R, int C, int[][] cells) {
        int ldr[]=new int[R*C+2];
        for(int i=0;i<R*C+2;i++) ldr[i]=i;
        int days = 0;
        int diff[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean [] water = new boolean[R * C + 2];
        for(int[] cell:cells){
            int row=cell[0],col=cell[1];
            row--; col--;

            water[gci(row,col,C)]=true;
            for(int i=0;i<8;i++){
                int ar=row+diff[i][0],ac=col+diff[i][1];
                if(ar>=0 && ar<R && ac>=0 && ac<C){
                    if(water[gci(ar,ac,C)]){
                        join (ldr,gci(row,col,C),gci(ar,ac,C));
                    }
                }
            }
            if(col==0){
                join(ldr,0,gci(row,col,C));
            }else if(col==(C-1)){
                join(ldr,gci(row,col,C),R*C+1);
            }
            if(find(ldr,0)==find(ldr,R*C+1)){
                break;
            }
            days++;
        }
        return days;
    }
}

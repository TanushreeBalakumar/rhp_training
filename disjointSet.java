class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};

    HashMap<Integer,Integer> size=new HashMap<>();

    public void dfs(int row,int col,int [][]grid,int change){

        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]!=1)
            return;

        
        grid[row][col]=change;

        
        size.put(change,size.getOrDefault(change,0)+1);

        
        for(int i=0;i<4;i++){
            dfs(row+dx[i],col+dy[i],grid,change);
        }
    }

    public int largestIsland(int[][] grid) {

        m=grid.length;
        n=grid[0].length;

        int change=2;

        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,change);
                    change++;
                }
            }
        }

        int ans=0;

        
        for(int islandSize:size.values()){
            ans=Math.max(ans,islandSize);
        }

        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==0){

                    HashSet<Integer> set=new HashSet<>();

                    
                    for(int k=0;k<4;k++){

                        int nr=i+dx[k];
                        int nc=j+dy[k];

                        if(nr<0 || nc<0 || nr>=m || nc>=n)
                            continue;

                        if(grid[nr][nc]>1)
                            set.add(grid[nr][nc]);
                    }

                    
                    int current=1;

                    
                    for(int id:set){
                        current+=size.get(id);
                    }

                    ans=Math.max(ans,current);
                }
            }
        }

        return ;
    }
}

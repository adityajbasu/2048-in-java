package Project;

import java.util.Random;

public class Matrix {
    int[][] start_mat(){
        int[][]mat={{0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}};
        System.out.println("w to go up\nd to go down\na to go left\nd to go right");
        mat=add_rand2(mat);
        return mat;
    }
    int [][] add_rand2(int[][]grid){
        Random rand = new Random();
        int r = rand.nextInt(3);
        int c = rand.nextInt(3);
        while(grid[r][c]!=0){
            r = rand.nextInt(3);
            c = rand.nextInt(3);
        }
        grid[r][c]=2;
        return grid;
    }
    String check_state(int[][]mat){
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(mat[i][j]==2048){
                    return "Game won";
                }
                else if(mat[i][j]==0){
                    return "game not over";
                }
                else if(mat[i][j]==mat[i][j+1] || mat[i][j]==mat[i+1][j]){
                    return "game not over";
                }
            }
        }
        return "lost";
    }
    int[][] merge(int[][]mat, int a, int b, int c, int z, int y, int g){
        if(c==1){
            for (int i=z;i<y;i++){
                for (int j=z;j<g;j++){
                    if(mat[i][j]==mat[i+a][j+b] && mat[i][j]!=0){
                        mat[i][j]*=2;
                        mat[i+a][j+b]=0;
                    }
                }
            }
        }
        else if(c==2){
            for (int i=z;i>y;i--){
                for (int j=z;j>g;j--){
                    if(mat[i][j]==mat[i+a][j+b] && mat[i][j]!=0){
                        mat[i][j]*=2;
                        mat[i+a][j+b]=0;
                    }
                }
            }
        }
        return mat;
    }
    int[][] move(int[][]mat, int d, int e, int f, int x, int w, int h){
        if(f==1){
            for (int i=x;i<w;i++){
                for (int j=x;j<h;j++){
                    if(mat[i+d][j+e]==0){
                        mat[i+d][j+e]=mat[i][j];
                        mat[i][j]=0;
                    }
                }
            }
        }
        else if(f==2){
            for (int i=x;i>w;i--){
                for (int j=x;j>h;j--){
                    if(mat[i+d][j+e]==0){
                        mat[i+d][j+e]=mat[i][j];
                        mat[i][j]=0;
                    }
                }
            }
        }
        return mat;
    }
    boolean check_change(int[][]mat, int[][]mat1){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(mat[i][j]!=mat1[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    int[][] copy_mat(int[][]mat){
        int[][]matr= new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                matr[i][j]=mat[i][j];
            }
        }
        return matr;
    }
    void display(int[][]mat){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

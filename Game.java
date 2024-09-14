package Project;
import java.util.Scanner;
import Project.Matrix;
public class Game {
    public static void main(String[] args) {
        Matrix m=new Matrix();
        Scanner sc1=new Scanner(System.in);
        int[][]mat=m.start_mat();
        int [][]matr=m.copy_mat(mat);
        while(true){
            char ch= sc1.nextLine().charAt(0);
            if(ch=='w'){
                boolean a=true;
                while(a){
                    int[][]uu=m.copy_mat(matr);
                    matr=m.move(matr, -1, 0, 2, 3, 0, -1);
                    matr=m.merge(matr, 1, 0, 1, 0, 3, 4);
                    a=m.check_change(matr, uu);
                }
            }
            else if(ch=='s'){
                boolean a=true;
                while(a){
                    int[][]ud=m.copy_mat(matr);
                    matr=m.move(matr, 1, 0, 1, 0, 3, 4);
                    matr=m.merge(matr, -1, 0, 2, 3, 0, -1);
                    a=m.check_change(matr, ud);
                }
            }
            else if(ch=='a'){
                boolean a=true;
                while(a){
                    int[][]ul=m.copy_mat(matr);
                    matr=m.move(matr, 0, -1, 2, 3, -1, 0);
                    matr=m.merge(matr, 0, 1, 1, 0, 4, 3);
                    a=m.check_change(matr, ul);
                }
            }
            else if(ch=='d'){
                boolean a=true;
                while(a){
                    int[][]ur=m.copy_mat(matr);
                    matr=m.move(matr, 0, 1, 1, 0, 4, 3);
                    matr=m.merge(matr, 0, -1, 2, 3, -1, 0);
                    a=m.check_change(matr, ur);
                }
            }
            
            String status=m.check_state(matr);
            if(status=="game not over"){
                if(m.check_change(mat, matr)){
                    matr=m.add_rand2(matr);
                }
                mat=m.copy_mat(matr);
                
                m.display(mat);
            }
            else{
                mat=m.copy_mat(matr);
                m.display(mat);
                System.out.println(status);
                System.exit(0);
            }
        }
    }
}

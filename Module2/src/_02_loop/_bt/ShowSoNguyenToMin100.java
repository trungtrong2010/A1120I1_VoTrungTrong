package _02_loop._bt;
public class ShowSoNguyenToMin100 {
    public static void main(String[] args) {
        int count=1;
        for (int i = 2; count <= 100; i++ ){
            int check =0;
            for (int j=1; j <= i; j++ ){
                if (i % j == 0){
                    check++;
                }
            }
            if (check==2){
                System.out.println(count+". "+i);
                count++;
            }
        }
    }
}

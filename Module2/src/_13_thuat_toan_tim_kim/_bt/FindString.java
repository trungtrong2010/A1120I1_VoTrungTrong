package _13_thuat_toan_tim_kim._bt;

public class FindString {

    public static void main(String[] args) {
        String string = "ebdafgth";
        char[] arr = string.toCharArray();
        System.out.println(arr[0]);
        int ss = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ss) {
                System.out.println(arr[i]);
                ss = arr[i];
            }
        }
    }
}

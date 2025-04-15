public class RodCutting {

    public static int rodCutting(int length[], int price[]){
        int n= price.length;
        int dp[ ][]= new int[n+1][n+1];
        
        
        for( int i=1;i<n+1; i++){
            for(int j=1;j<n+1;j++){
                if( length[i-1]<= j)
            }
        }
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17 };
        System.out.println(rodCutting(length, price));
    }
}
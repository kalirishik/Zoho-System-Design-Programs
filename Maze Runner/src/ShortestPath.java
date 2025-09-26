import java.util.Scanner;
class ShortestPath{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Matrix Dimension (nxn): ");
        int n=sc.nextInt();
        char ch[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ch[i][j]='0';
            }
        }
        System.out.print("Enter Adventure Position (row col): ");
        int aRow=sc.nextInt();
        int aCol=sc.nextInt();
        ch[aRow][aCol]='A';
        System.out.print("Enter Destination Position (row col): ");
        int dRow=sc.nextInt();
        int dCol=sc.nextInt();
        ch[dRow][dCol]='D';
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ch[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Shortest Path : "+findShortestPath(aRow,aCol,dRow,dCol));
    }
    public static int findShortestPath(int startX, int startY,int endX, int endY){
        return Math.max(Math.abs(endX-startX),Math.abs(endY-startY));
    }
}
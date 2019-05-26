package array2d;

public class Array2D {

    private int arr[][];


    public Array2D(int n)
    {
        arr=new int[n][n];
    }


    public int getValueAtPos(int i,int j)
    {
        if(i<0 ||j<0||i>=arr.length||j>=arr[0].length)
            return -1;//or throw custom exception

        return arr[i][j];
    }

    public void setValueAtPos(int i,int j,int val)
    {
        if(i<0 ||j<0||i>=arr.length||j>=arr[0].length)
            throw new RuntimeException();
        arr[i][j]=val;
    }

    public int minimumCost()
    {
        //prepare a cost arr
        int costarr[][] = new int[arr.length][arr[0].length];

        //first row costs the same
        //copying - start
        costarr[0][0]=arr[0][0];
        for(int i=1;i<arr.length;i++)
        {
            costarr[0][i]=costarr[0][i-1]+arr[0][i];
            costarr[i][0]=costarr[i-1][0]+arr[i][0];
        }
        // start painting columns and rows with minimum cost
        for(int i=1;i<arr.length;i++)
        {
            
        }
        return 0;
    }


}

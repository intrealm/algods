package array2d;

public class Array2D {

    private int arr[][];

   static  class RepThisOne
    {
        private int arr[][];
        public RepThisOne(int arr[][])
        {
            this.arr = arr;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            int n = arr.length;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    sb.append(String.format("##%2d",arr[i][j]));
                }
                sb.append(System.getProperty("line.separator"));
            }

            return sb.toString();
        }
    }


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

        RepThisOne origin = new RepThisOne(this.arr);
        RepThisOne cost = new RepThisOne(costarr);
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
            for(int j=1;j<arr.length;j++)
            {
                //0 2    0 2    or      0 2
                //3 2    3 4            3 5
                if(arr[i][j]+costarr[i][j-1] > arr[i][j]+costarr[i-1][j])
                    costarr[i][j]=arr[i][j]+costarr[i-1][j];
                else
                    costarr[i][j]=arr[i][j]+costarr[i][j-1];
            }

        }
        return costarr[arr.length-1][arr[0].length-1];
    }


    public int minimumCostWithBlockers()
    {
        //prepare a cost arr
        int costarr[][] = new int[arr.length][arr[0].length];

        RepThisOne origin = new RepThisOne(this.arr);
        RepThisOne cost = new RepThisOne(costarr);
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
            for(int j=1;j<arr.length;j++)
            {
                if(arr[i][j]<0)
                    costarr[i][j]=-1;

                if(costarr[i][j-1]==-1)
                {
                    costarr[i][j]=costarr[i-1][j];
                }
                else if(costarr[i-1][j]==-1)
                {
                    costarr[i][j]=costarr[i][j-1];
                }
                else
                {
                    //0 2    0 2    or      0 2
                    //3 2    3 4            3 5
                    if(arr[i][j]+costarr[i][j-1] > arr[i][j]+costarr[i-1][j])
                        costarr[i][j]=arr[i][j]+costarr[i-1][j];
                    else
                        costarr[i][j]=arr[i][j]+costarr[i][j-1];
                }


            }

        }
        return costarr[arr.length-1][arr[0].length-1];
    }

}

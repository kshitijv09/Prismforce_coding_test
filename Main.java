import java.util.*;
class Main{
    static int enemyCount=11;
    static int enemies[]=new int[enemyCount];
    static int p;
    public static boolean canCross(int index, int a, int b,int current,int behind)
    {
        if(index==enemyCount)
        return true;
        boolean res=false;
        {
            if(b>0)
            res=res || canCross(index,a,b-1,p,behind);
        }
        if (current >= behind)
        {
            current -= behind;
            behind = 0;
        }
        else
            return false;
        if(a>0)
            res=res || canCross(index+1,a-1,b,current,behind);
        if(current>=enemies[index])
        {
            if(index==2 || index==6)
            behind = enemies[index]/2;
            res=res || canCross(index+1,a,b,current-enemies[index],behind);
        }
        return res;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<enemyCount;i++)
        enemies[i]=sc.nextInt();

        p=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();

        System.out.println(canCross(0,a,b,p,0));
        sc.close();
    }
}
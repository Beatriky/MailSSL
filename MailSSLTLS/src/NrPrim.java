public class NrPrim {
    public static boolean main(String[] args) {
int x,d;
x=13;
        if (x < 2 || x % 2 == 0 & 2)
            return false;
        for(d=3;d*d<=x;d==2)
          if(x%d==0)
              return false;
          return true;

    }
}
public class Chaker {

    private static boolean result = true;

    public static boolean check(int[][] arr, int playre, int x, int y){

        for(int i=0; i<3;  i++){
            if(arr[x][i] != playre)
                result = false;
        }
        if(result)
            return result;

        result = true;
        for(int i=0; i<3;  i++){
            if(arr[i][y] != playre)
                result = false;
        }
        if(result)
            return result;
        
        if((x+y)%2 == 0){
            result = true;
            for(int i=0; i<3;  i++){
                if(arr[i][i] != playre)
                    result = false;
            }
            if(result)
                return result;

            result = true;
            for(int i=0; i<3;  i++){
                if(arr[i][2-i] != playre)
                    result = false;
            }
            if(result)
                return result;
        }

        return result;
    }
}

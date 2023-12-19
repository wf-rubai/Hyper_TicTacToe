public class Chaker {

    public static boolean check(int[][] arr, int playre, int x, int y){

        // System.out.println(arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + "\n");
        // System.out.println(arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + "\n");
        // System.out.println(arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + "\n\n");
        boolean result = true;

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

    public static boolean draw(int[][] arr){

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(arr[i][j] == 0)
                    return false;
            }
        }

        return true;
    }
}

package matrix;

import java.util.Arrays;

public class BigestOfMatrix {
	
	public int getResult(int[][] array){
		int[] resultArray = new int[getSize(array)];
		int index=0;
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				for(int k=1; k<=array.length; k++){
					if(subArray(array, i, j, k)!=-1){
						resultArray[index] = subArray(array, i, j, k);
						index++;
					}
				}
			}
		}
		Arrays.sort(resultArray);
		return resultArray[resultArray.length-1];
	}
	
	public int getSize(int[][] array){
		int hight = array.length;
		int size=0;
		for(int i=0;i<=hight;i++){
			size += i*i;
		}
		return size;
	}
	
	public int subArray(int[][] array,int xStart,int yStart,int size){
		int maxSize =array.length;
		if ((xStart+size)>maxSize || (yStart+size)>maxSize){
			return -1;
		} else{
			for(int i = xStart; i< xStart + size ; i++){
				for (int j = yStart; j < yStart + size ; j++) {
					if(array[i][j]==0){
						return 0;
					}
				}
			}
			return size * size;
		}

	}
	
	public boolean isSquare(int[][] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;i<array[0].length;j++){
				if(array[i][j]==0){
					return false;
				}
			}
		}
			
		return true;
	}
	public static void main(String[] args) {
		int[][] matrix ={ {1,0,1,1,1} , {1,0,1,1,1} , {1,1,1,1,1} , {1,0,0,1,0} , {1,0,0,1,0}};
		BigestOfMatrix test=new BigestOfMatrix();
		System.out.println(test.getResult(matrix));
	}
}

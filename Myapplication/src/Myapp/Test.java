package Myapp;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Test {

		public static void shortPath(int[][] b) {
			int a[][] = {
					{1,1,1,1},
					{4,5,6,3},
					{7,8,9,23},
					{2,1,2,2}
			};
			int pos1 = 0;
			int pos2 = 0;
			while(pos1 < a.length && pos2 < a[a.length-1].length) {
				System.out.println(a[pos1][pos2]);
				if(pos1 == a.length-1 && pos2 == a[a.length-1].length-1)break;
				else if(pos1 == a.length-1) ++pos2;else if(pos2 == a[a.length-1].length-1) ++pos1;
				else if(a[pos1+1][pos2] < a[pos1][pos2+1])
					++pos1; else ++pos2; 
				

			}
			System.out.println(pos1 + " "+ pos2);
				
		}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		System.out.println("hello");
		Callable<Integer> c = new Callable<Integer>() {

			
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return new Random().nextInt(4)+0;
			}
		
		};
		
		Future<Integer> f =executorService.submit(c);
		System.out.println(f.get());
		
	
	}

	
	
}

package juc.forkjoin;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Test2 {
	static final class SumTask extends RecursiveTask<BigDecimal> {
		private static final long serialVersionUID = 1L;
		
		final BigDecimal start; //开始计算的数
		final BigDecimal end; //最后计算的数
		
		SumTask(BigDecimal start, BigDecimal end) {
			this.start = start;
			this.end = end;
		}

		@Override
		protected BigDecimal compute() {
			//如果计算量小于1000，那么分配一个线程执行if中的代码块，并返回执行结果
			if(end.subtract(start).compareTo(new BigDecimal("1000")) < 0) {
				System.out.println(Thread.currentThread().getName() + " 开始执行: " + start + "-" + end);
				BigDecimal sum = BigDecimal.ZERO;
				for(int i = start.intValue(); i <= end.intValue(); i++)
					sum = sum.add(new BigDecimal(i));
				return sum;
			}
			//如果计算量大于1000，那么拆分为两个任务
			BigDecimal end2 = (start.add(end)).divide(new BigDecimal("2"),0,BigDecimal.ROUND_HALF_UP);
			SumTask task1 = new SumTask(start, end2);
			SumTask task2 = new SumTask(end2.add(new BigDecimal("1")), end);
			//执行任务
			task1.fork();
			task2.fork();
			//获取任务执行的结果
			return task1.join().add(task2.join());
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long l = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<BigDecimal> task = new SumTask(new BigDecimal("0"), new BigDecimal("10000000000"));
		pool.submit(task);
		System.out.println(task.get());
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l);
	}
}
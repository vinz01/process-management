package adsproj;

import java.util.*;

class inputThread extends Thread
{
	int x=0;
	public void run()
	{
                Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value(Please enter 0 if no value, without fail)");
		x=sc.nextInt();
	}
}

class Heapclass extends Thread
{
	int x;
	MinHeap obj;
	public Heapclass(int data,MinHeap obj)
	{
		x=data;
		this.obj=obj;
	}
	public void run()
	{
            System.out.println("Data recieved is "+x);

		if(x!=0 && x>0)
		{
			obj.insert(x);
		}
                obj.decrease_min_key_by1();
                obj.print_Heap();
	}
}

class Adsproj
{
	public static void main(String args[])
	{
		System.out.println("Enter Initial Number of Jobs");
		int num,i;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		MinHeap obj=new MinHeap();
		for(i=0;i<num;i++)
		{
			System.out.println("Enter the Time Required to complete the Job(Integers > 0 only)");
			int job=sc.nextInt();
                        if(job>0)
                        {
                            obj.insert(job);
                        }
                           else
                        {
                            System.out.println("Invalid Input!!");
                            i--;
                        }
		}
		obj.print_Heap();
                
		while((obj.isEmpty())!=1)
                {
                        inputThread obj1=new inputThread();
                        obj1.start();
			try
			{
				obj1.sleep(5000);
			}
			catch(Exception e){}
			Heapclass obj2=new Heapclass(obj1.x,obj);
			obj2.start();
                        try
			{
				obj2.join();
			}
			catch(Exception e){}
                }
                System.out.println("All Processes have Finished, Thank You!!");
	}
}

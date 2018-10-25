package adsproj;

public class MinHeap
{
    public int[] Heap;
    public int size;
    public final int maxsize=100;
 
    public static final int Min = 1;
	
	public int isEmpty()
	{
		if(this.size==0)
		{
			return 1;
		}
		return 0;
	}
	
	public void decrease_min_key_by1()
	{
		Heap[Min]--;
                if(Heap[Min]==0)
                {
                    int zuze=Extract_Min();
                }
	}
    public MinHeap()
    {
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = 0;
    }
 
    public int parent(int pos)
    {
        return pos / 2;
    }
 
    public int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    public int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    public boolean isLeaf(int pos)
    {
        if (pos >  (size / 2)  &&  pos <= size)
        { 
            return true;
        }
        return false;
    }
 
    public void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    public void Min_Heapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( Heap[pos] > Heap[leftChild(pos)]  || Heap[pos] > Heap[rightChild(pos)])
            {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    Min_Heapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    Min_Heapify(rightChild(pos));
                }
            }
        }
    }
 
    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
 
    public void print_Heap()
    {
        System.out.print("Heap is : ");
        for (int i = 1; i <= size; i++ )
        {
            System.out.print(Heap[i]+"\t");
        }
		System.out.println();
    }
 
    public void Build_MinHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            Min_Heapify(pos);
        }
    }
 
    public int Extract_Min()
    {
        int popped = Heap[Min];
        Heap[Min] = Heap[size--];
        Min_Heapify(Min);
        return popped;
    }
}

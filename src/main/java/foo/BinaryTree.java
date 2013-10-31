package foo;
import java.util.ArrayList;;


public class BinaryTree 
{
	private int value;
	private BinaryTree lower;
	private BinaryTree greater;
	
	public BinaryTree(int input)
	{
		this.lower=null;
		this.greater=null;
		this.value=input;
	}
	
	public boolean exists(int number)
	{
		BinaryTree currtree=this;
		while(currtree!=null)
		{
			if(currtree.value==number) return true;
			if(currtree.value<number)
			{
				currtree=currtree.greater;
				continue;
			}
			else
			{
				currtree=currtree.lower;
			}
		}
		return false;
	}
	
	public boolean add(int input)
	{	BinaryTree curtr=this;
		if(curtr.exists(input)) return false;
			if (curtr.value<input)
			{
				if(curtr.greater==null)
				{
					curtr.greater = new BinaryTree(input);
					return true;
				}
				return curtr.greater.add(input);
			}
			else
			{
				if(curtr.lower==null)
				{
					curtr.lower = new BinaryTree(input);
					return true;
				}
				return curtr.lower.add(input);
			}
		
	}

	public void printByWidth()
	{
		System.out.println(this.value);
		if(this.lower!=null) this.lower.printByWidth();
		if(this.greater!=null) this.greater.printByWidth();
		return;		
	}

	public void printByDepth()
	{
		BinaryTree tree=this;
		ArrayList	<BinaryTree> printlst = new ArrayList<BinaryTree>();
		printlst.add(this);
		int i=0;
		while(i<printlst.size())
		{
			tree=printlst.get(i);
			System.out.println(printlst.get(i).value);
			if(tree.lower!=null) printlst.add(tree.lower);
			if(tree.greater!=null) printlst.add(tree.greater);
			i++;
			
		}
		return;
	}

	public void addSubTree(BinaryTree tree)
	{
		if(tree==null) return;
		this.add(tree.value);
		this.addSubTree(tree.lower);
		this.addSubTree(tree.greater);
		return;
	}
	
	private boolean updTree(BinaryTree tree)
	{
		if (tree==null) return false;
		this.greater=tree.greater;
		this.lower=tree.lower;
		this.value=tree.value;
		return true;
	}
	
	public boolean remove(int input)
	{
		BinaryTree temp;
		if (!this.exists(input)) return false;
		if ((this.greater==null)&(this.lower==null)) return false;
		if (this.value==input)
		{
			if (this.greater==null)
			{
				this.updTree(this.lower);
				return true;
			}
			else
			{
				temp=this.lower;
				this.updTree(this.greater);
				this.addSubTree(temp);
				return true;
			}
		}
		BinaryTree currtree=this;
		while(true)
		{
			if ((this.greater!=null)&(currtree.greater.value==input))
			{
				temp=currtree.greater.greater;
				currtree.greater=currtree.greater.lower;
				currtree.addSubTree(temp);
				return true;
			}
			if ((this.lower!=null)&(currtree.lower.value==input))
			{
				temp=currtree.lower.greater;
				currtree.lower=currtree.lower.lower;
				currtree.addSubTree(temp);
				return true;
			}
			if ((this.greater!=null)&(input>currtree.value))
			{
				currtree=currtree.greater;
				continue;
			}
			if ((this.lower!=null)&(input<currtree.value))
			{
				currtree=currtree.lower;
				continue;
			}
			return false;
			
		}
	
	}
}

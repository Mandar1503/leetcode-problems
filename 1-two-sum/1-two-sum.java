class Solution{
	public int[] twoSum(int[] numbers,int target)
	{
		HashMap<Integer,Integer> hs = new HashMap<>();
		
		for(int i=0;i<numbers.length;i++)
		{
			int no = target - numbers[i];
			if(hs.containsKey(no))
				return new int[] {hs.get(no),i};
			else
				hs.put(numbers[i],i);
		}
		return null;
	}
}

import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int get = nums.length / 2;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int cnt = map.size();
        
        if(cnt > get){
            return get;
        }else{
            return cnt;
        }
    }
}
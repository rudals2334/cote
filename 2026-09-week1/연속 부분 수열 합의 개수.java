import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < elements.length; j++){
                int a = 0;
                for(int k = 0; k < i; k++){
                    a += elements[(j+k)%n];
                }
                set.add(a);
            }
        }
        return set.size();
    }
}
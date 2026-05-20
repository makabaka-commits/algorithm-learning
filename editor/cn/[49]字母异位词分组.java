//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 
//
// 示例 1: 
//
// 
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 
// 
//
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 解释： 
//
// 
// 在 strs 中没有字符串可以通过重新排列来形成 "bat"。 
// 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。 
// 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。 
// 
//
// 示例 2: 
//
// 
// 输入: strs = [""] 
// 
//
// 输出: [[""]] 
//
// 示例 3: 
//
// 
// 输入: strs = ["a"] 
// 
//
// 输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2709 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (exist(out, strs[i])) {
                continue;
            }
            List<String> result = new ArrayList<>();
            result.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                boolean state = analisy(strs[i], strs[j]);
                if (state) {
                    result.add(strs[j]);
                }
            }
            out.add(result);
        }
        return out;
    }

    public boolean analisy(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int x : table) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean exist(List<List<String>> x, String y) {
        for (List<String> z : x) {
            if (z.contains(y)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

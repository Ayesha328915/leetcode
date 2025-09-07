class Solution {
         private static final String[] KEYS = {
        "",    "",    "abc", "def", "ghi", 
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        solve(digits, 0, "", result);
        return result;
    }

    private void solve(String digits, int index, String path, List<String> result) {
        if (index == digits.length()) {
            result.add(path);
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            solve(digits, index + 1, path + c, result);
        }
        
    }
}
package com.xcode.javas.geeksforgeeks.algorithm.analysis;

/**
 * Created by jarvis on 30/6/17.
 */
public class _2AnalysisOfLoops
{
    public static void main(String[] args)
    {
        // set of non-recursive and non-loop statements     // O(1)

        // Here c is a positive integer constant
        int n = 10, c = 2, m = 20;
        for (int i = 1; i <= n; i += c) {
            // some O(1) expressions                        // O(n)
        }

        for (int i = n; i > 0; i -= c) {
            // some O(1) expressions                        // O(n)
        }

        for (int i = 1; i <=n; i += c) {
            for (int j = 1; j <=n; j += c) {
                // some O(1) expressions                    // O(n^c)
            }
        }

        for (int i = n; i > 0; i += c)
        {
            for (int j = i + 1; j <= n; j += c)
            {
                // some O(1) expressions                    // O(n^c)
            }
        }

        for (int i = 1; i <=n; i *= c) {
            // some O(1) expressions                        // O(log(n))
        }
        for (int i = n; i > 0; i /= c) {
            // some O(1) expressions                        // O(log(n))
        }

        // Here c is a constant greater than 1
        for (int i = 2; i <=n; i = (int) Math.pow(i, c)) {
            // some O(1) expressions                        // O(loglog(n))
        }
        //Here fun is sqrt or cuberoot or any other constant root
        for (int i = n; i > 0; i = (int) Math.sqrt(i)) {
            // some O(1) expressions                        // O(loglog(n))
        }

        for (int i = 1; i <=m; i += c) {
            // some O(1) expressions
        }
        for (int i = 1; i <=n; i += c) {
            // some O(1) expressions
        }
        //Time complexity of above code is O(m) + O(n) which is O(m+n)
        //If m == n, the time complexity becomes O(2n) which is O(n).
    }
}

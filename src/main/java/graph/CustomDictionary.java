package src.main.java.graph;


import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CustomDictionary {

    private Set<GNodeV2<Character>> firstCharacter;

    public CustomDictionary() {
        firstCharacter = new HashSet<>();
    }

    public boolean isAWord(String str) {
        return false;
    }

    public void addAWord(String word) {
        if (word != null) { //empty check would be fine too
            //find the set till dictionary is not yet populated
            Set<GNodeV2<Character>> currSet = this.firstCharacter;
            char[] charArr = word.toCharArray();

            if (charArr.length < 1) {
                return;
            }
            //till what index its already available
            // x
            int x = 0;
            GNodeV2<Character> lastGNodePresent = null;
            while (x<charArr.length) {
                boolean nodeNotPresent = true;
                for (GNodeV2<Character> node : currSet) {
                    if (node.getVal().equals(Character.valueOf(charArr[x]))) {
                        currSet = node.getMatchsTo();
                        x++;
                        nodeNotPresent = false;
                        lastGNodePresent = node;
                        break;
                    }
                }
                if (nodeNotPresent) {
                    break;
                }
            }


            if (lastGNodePresent==null || this.firstCharacter.isEmpty()) {
                lastGNodePresent = new GNodeV2<>(charArr[x++]);
                firstCharacter.add(lastGNodePresent);
            }
            for (; x < charArr.length; x++) {
                GNodeV2<Character> currNode = new GNodeV2<>(Character.valueOf(charArr[x]));
                Set<GNodeV2<Character>> set = lastGNodePresent.getMatchsTo();
                set.add(currNode);
                currNode.setComesFrom(lastGNodePresent);
                lastGNodePresent = currNode;
            }
            lastGNodePresent.setDoesItMakeAnySense(true);//makesupas a valid word
        }
    }

    public int getWordCounts() {
        if (this.firstCharacter.isEmpty())
            return 0;
        int count=0;
        for(GNodeV2 node:this.firstCharacter)
        count+=getCountonGNode(node,true);
        return count;
    }

    private int getCountonGNode(GNodeV2<Character> node, boolean isAWord)
    {

        int count=isAWord?(node.isDoesItMakeAnySense()?1:0):1;
        for(GNodeV2 leadsToNode:node.getMatchsTo())
            count+=getCountonGNode(leadsToNode,isAWord);
        return count;
    }

    public int getNodeCounts()
    {
        if (this.firstCharacter.isEmpty())
            return 0;
        int count=0;
        for(GNodeV2 node:this.firstCharacter)
            count+=getCountonGNode(node,false);
        return count;
    }
}

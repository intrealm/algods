package src.main.java.graph;


import java.util.HashMap;
import java.util.Map;

public class CustomMapDictionary {

    private Map<Character,GNodeV3<Character>> firstCharactersMap;

    public CustomMapDictionary() {
        firstCharactersMap = new HashMap<>();
    }

    public boolean isAWord(String str) {
        return false;
    }

    public void addAWord(String word) {
        if (word != null) { //empty check would be fine too
            //find the set till dictionary is not yet populated
            Map<Character,GNodeV3<Character>> currMap = this.firstCharactersMap;
            char[] charArr = word.toCharArray();

            if (charArr.length < 1) {
                return;
            }
            //till what index its already available
            // x
            int x = 0;
            GNodeV3<Character> lastGNodePresent =null;
            while (x<charArr.length) {
                boolean nodeNotPresent = true;
                if(currMap.containsKey(Character.valueOf(charArr[x])))
                {
                    nodeNotPresent = false;
                    lastGNodePresent = currMap.get(Character.valueOf(charArr[x]));;
                    x++;
                    currMap = lastGNodePresent.getLeadsTo();
                }
                if (nodeNotPresent) {
                    break;
                }
            }


            if (lastGNodePresent==null) {
                lastGNodePresent = new GNodeV3<>(charArr[x++]);
            }
            if(firstCharactersMap.isEmpty())
            {
                firstCharactersMap.put(lastGNodePresent.getVal(),lastGNodePresent);
            }
            for (; x < charArr.length; x++) {
                GNodeV3<Character> currNode = new GNodeV3<>(Character.valueOf(charArr[x]));
                Map<Character,GNodeV3<Character>> map = lastGNodePresent.getLeadsTo();
                map.put(currNode.getVal(),currNode);
                currNode.setLeadFrom(lastGNodePresent);
                lastGNodePresent = currNode;
            }
            lastGNodePresent.setDoesItMakeAnySense(true);//makesupas a valid word
        }
    }

    public int getWordCounts() {
        if (this.firstCharactersMap.isEmpty())
            return 0;
        int count=0;
        for(GNodeV3 node:this.firstCharactersMap.values())
        count+=getCountonGNode(node,true);
        return count;
    }

    private int getCountonGNode(GNodeV3<Character> node, boolean isAWord)
    {

        int count=isAWord?(node.isDoesItMakeAnySense()?1:0):1;
        for(GNodeV3 leadsToNode:node.getLeadsTo().values())
            count+=getCountonGNode(leadsToNode,isAWord);
        return count;
    }

    public int getNodeCounts()
    {
        if (this.firstCharactersMap.isEmpty())
            return 0;
        int count=0;
        for(GNodeV3 node:this.firstCharactersMap.values())
            count+=getCountonGNode(node,false);
        return count;
    }
}

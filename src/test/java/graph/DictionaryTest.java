package src.test.java.graph;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.graph.CustomDictionary;
import src.main.java.graph.CustomMapDictionary;

import java.util.Dictionary;
import java.util.Hashtable;

public class DictionaryTest {

    @Test
    public void test_dict_set()
    {

        CustomDictionary dictionary = new CustomDictionary();
        dictionary.addAWord("hello");
        Assert.assertEquals(5,dictionary.getNodeCounts());
        Assert.assertEquals(1,dictionary.getWordCounts());
        dictionary.addAWord("help");
        Assert.assertEquals(6,dictionary.getNodeCounts());
        Assert.assertEquals(2,dictionary.getWordCounts());
        dictionary.addAWord("hell");
        Assert.assertEquals(6,dictionary.getNodeCounts());
        Assert.assertEquals(3,dictionary.getWordCounts());

        dictionary.addAWord("a");
        Assert.assertEquals(7,dictionary.getNodeCounts());
        Assert.assertEquals(4,dictionary.getWordCounts());
    }

    @Test
    public void test_dict_map()
    {

        CustomMapDictionary dictionary = new CustomMapDictionary();
        dictionary.addAWord("hello");
        Assert.assertEquals(5,dictionary.getNodeCounts());
        Assert.assertEquals(1,dictionary.getWordCounts());
        dictionary.addAWord("help");
        Assert.assertEquals(6,dictionary.getNodeCounts());
        Assert.assertEquals(2,dictionary.getWordCounts());
        dictionary.addAWord("hell");
        Assert.assertEquals(6,dictionary.getNodeCounts());
        Assert.assertEquals(3,dictionary.getWordCounts());

        dictionary.addAWord("a");
        Assert.assertEquals(7,dictionary.getNodeCounts());
        Assert.assertEquals(4,dictionary.getWordCounts());

    }
}

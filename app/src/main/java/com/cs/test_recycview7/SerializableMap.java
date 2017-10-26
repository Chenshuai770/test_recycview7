package com.cs.test_recycview7;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/26/026.
 */

public class SerializableMap implements Serializable {

    private Map<Integer,List<String >> map;

    public Map<Integer, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<String>> map) {
        this.map = map;
    }
}

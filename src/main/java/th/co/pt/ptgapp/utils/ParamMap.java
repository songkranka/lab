package th.co.pt.ptgapp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamMap {

    private Map<String,Object> map;

    public ParamMap() {
        this.map = new HashMap<String,Object>();
    }

    public Map<String,Object> get() {
        return this.map;
    }

    public void setParamMap(HashMap<String,Object> hm){
        this.map = hm;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void put(String key, int value) {
        map.put(key, new Integer(value));
    }

    public void put(String key, float value) {
        map.put(key, new Float(value));
    }

    public void put(String key, long value) {
        map.put(key, new Long(value));
    }

    public void put(String key, double value) {
        put(key, new Double(value));
    }

    public void put(String key, String value) {
        if(value == null) value = "";
        map.put(key, new String(value));
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public int getInt(String key) {
        if(map.containsKey(key) == false) return 0;
        if(objToStr(map.get(key),"").equals("")) return 0;
        return Integer.parseInt(map.get(key).toString());
    }

    public float getFloat(String key) {
        if(map.containsKey(key) == false) return 0;
        if(objToStr(map.get(key),"").equals("")) return 0;
        return Float.parseFloat(map.get(key).toString());
    }

    public long getLong(String key) {
        if(map.containsKey(key) == false) return 0;
        if(objToStr(map.get(key),"").equals("")) return 0;
        return (long)Double.parseDouble(map.get(key).toString());
    }

    public double getDouble(String key) {
        if(map.containsKey(key) == false) return 0;
        if(objToStr(map.get(key),"").equals("")) return 0;
        return Double.parseDouble(map.get(key).toString());
    }

    public String getString(String key) {
        if(map.containsKey(key) == false) return "";
        return objToStr(map.get(key),"");
    }

    public Object getObject(String key) {
        if(map.containsKey(key) == false) return null;
        return map.get(key);
    }

    public List<String> getList(String key) {
        if(map.containsKey(key) == false) return null;
        List<String> list = new ArrayList<>();
        String sl = String.valueOf(map.get(key));
        sl = sl.substring(1,sl.length()-1);
        for(String s: sl.split("\\,")){
            if(!s.trim().equals("on")) {
                list.add(s.trim());
            }
        }
        return list;
    }


    public String toString() {
        return map.toString();
    }

    private String objToStr(Object objVal, String emptyValue){
        if(objVal == null)		return emptyValue;
        if(objVal.equals(""))	return emptyValue;
        emptyValue = objVal.toString();
        return emptyValue;
    }
}
package lecture.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    /*
     * Map
     * -> Collection 인터페이스들과는 다른 저장방식
     * key, value 쌍으로 저장하는 방식
     *
     * key란?
     * - 값을 찾기 위한 이름 역할의 객체
     * - 키는 중복을 허용하지 않음, 키가 다르면 중복되는 값은 저장 가능
     * */

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("1", "java8");
        hashMap.put("2", "oracle");
        hashMap.put("3", "jdbc");
        hashMap.put("4", "html5");
        hashMap.put("5", "css3");
        hashMap.put("6", "css3");

        System.out.println("hashMap : " + hashMap);

        // 삭제
        hashMap.remove("1");
        System.out.println(hashMap);

        // getOrDefault(key, DefaultValue)
        // 지정한 키가 맵에 없을 때 기본값을 반환, 있을 때는 해당키의 value를 반환

        System.out.println("getOrDefault : " + hashMap.getOrDefault("2", "기본값"));

        // Iterator로 key value 출력
        System.out.println("============= Set 이용해 Iterator로 변환 =============");

        // keySet() : map에 저장된 모든 key를 Set형태로 반환
        Set<String> keys = hashMap.keySet();

        // iterator() -> iterator 객체 반환
        Iterator<String> keyIter = keys.iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();

            // key값으로 value 꺼냄
            String value = hashMap.get(key);

            System.out.println(key + " = " + value);
        }


        System.out.println("=========Map 내부의 EntrySet이용 ===========");
        // entrySet() : map에 저장된 key와 value쌍을 Set 형채로 "뷰"로 반환
        // -> 이때 반환된 Set은 MAp이랑 연결되어 있어서 추가수정삭제를 하면 원본에도 반영
        // Set<Map.Entry <K , V> > set = map.emtrySet();
        Set<Map.Entry<String, String>> set = hashMap.entrySet();

        Iterator<Map.Entry<String, String>> entryIter = set.iterator();
        while (entryIter.hasNext()) {
            Map.Entry<String, String> entry = entryIter.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }


    }


}

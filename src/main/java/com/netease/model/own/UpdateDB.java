package com.netease.model.own;

import java.util.*;
import java.util.stream.Collectors;

public class UpdateDB {
    public static void main(String[] args) {
        int currentSize = 11;
        int totalGroupNum = 2;

        Map<String, Integer> instanceGroupMap = new HashMap<>();

        Set<String> st = new HashSet<>();
        st.add("a");
        st.add("d");
        st.add("b");
        st.add("c");
        st.add("e");
        st.add("f");
        st.add("g");
        st.add("h");
        st.add("i");
        st.add("j");
        st.add("k");
        List<String> sortedInstances = st.stream().sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(sortedInstances);
        System.out.println(sortedInstances.size());

        int minBatchSize = currentSize / totalGroupNum; // 3
        int remainSize = currentSize % totalGroupNum;   // 2
        int i = 0;
        int preSize = 0;
        for (int groupId = 1; groupId <= totalGroupNum; groupId++) {
            int plusSize = (remainSize - groupId) >= 0 ? 1 : 0;

            int thisGroupIndex = preSize + minBatchSize + plusSize;

            thisGroupIndex = (thisGroupIndex > currentSize) ? currentSize : thisGroupIndex;
            while (i < thisGroupIndex) {
                instanceGroupMap.put(sortedInstances.get(i), groupId);
                i++;
                preSize++;
            }
        }

        System.out.println(instanceGroupMap);


        Set<String> instanceSet = instanceGroupMap.keySet();

//        List<UpdateIndexWork> allUpdateIndexWorks = instanceSet.stream()
//                .map(instanceHost -> {
//                    UpdateIndexWork updateIndexWork = buildUpdateIndexWork(instanceHost,
//                            requestData, instanceGroupMap.get(instanceHost));
//                    updateIndexWork.setShardInfo("");
//                    return updateIndexWork;
//                }).collect(Collectors.toList());
//

    }
}

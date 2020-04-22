package kr.co.chrisdev.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * 입출력 예
 * participant	        completion	            return
 * [leo, kiki, eden]	[eden, kiki]	        leo
 * [marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
 * [mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
 *
 */
public class Marathon {

    public static void main(String[] args) {
        String[] participant = {"mislav", "mislav", "stanko", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println("result : " + marathonHashMap(participant, completion));
    }

    private static String marathon(String[] participant, String[] completion) {
        /**
         * 접근법
         * 1. 처음엔 그냥 루프를 돌려서 체크했다.
         * 그랬더니 시간복잡도에서 탈락했다.
         *
         * 그래서 배열을 정렬한 후에 LOOP를 실행하여 선택해보도록 한다.
         *
         * 2. 배열 정렬 후 participant 마지막 인덱스에 있는 값을 정답으로 해봤다.
         * 그랬더니 중복된 값이 있는 경우에는 그 값을 제하고 체크해야 하는데 그걸 하지 못했다.
         *
         * 3. 완주자 명단 중 참가자이름이 같지 않다면 참가자 index 를 바로 리턴해버린다.
         * 중복값 없이 계속 같은 이름만 나왔다면 참가자 중 마지막 이름의 사람이 바로 혼자 남은 사람이다.
         */

        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println("sorted participant : " + Arrays.toString(participant));
        System.out.println("sorted completion : " + Arrays.toString(completion));

        int index = 0;
        for (String comp: completion) {
            if (!comp.equals(participant[index])) {
                return participant[index];
            }

            index++;
        }

        return participant[completion.length];
    }

    private static String marathonHashMap(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String part: participant) {
            hashMap.put(part, hashMap.getOrDefault(part, 0) + 1);
        }
        for (String comp: completion) {
            hashMap.put(comp, hashMap.get(comp) - 1);
        }

        for (Map.Entry<String, Integer> param: hashMap.entrySet()) {
            if (param.getValue() != 0) {
                answer = param.getKey();
            }
        }

        return answer;
    }
}
